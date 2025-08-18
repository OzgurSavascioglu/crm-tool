package ozgur.crmTool.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ozgur.crmTool.business.abstracts.NoteService;
import ozgur.crmTool.business.requests.note.CreateNoteRequest;
import ozgur.crmTool.business.requests.note.UpdateNoteRequest;
import ozgur.crmTool.business.responses.note.GetActiveNotesResponse;
import ozgur.crmTool.business.responses.note.GetAllNotesResponse;
import ozgur.crmTool.business.responses.note.GetByIdNoteResponse;
import ozgur.crmTool.core.utilities.exception.NotFoundException;
import ozgur.crmTool.core.utilities.mappers.ModelMapperService;
import ozgur.crmTool.core.utilities.validation.NoteValidationUtility;
import ozgur.crmTool.dataAccess.abstracts.NoteRepository;
import ozgur.crmTool.entities.concretes.Customer;
import ozgur.crmTool.entities.concretes.Note;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoteManager implements NoteService {
    private NoteRepository noteRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllNotesResponse> getAll() {
        List<Note> notes = noteRepository.findAll();
        List<GetAllNotesResponse> noteResponses = notes.stream()
                .map(note->this.modelMapperService.forResponse()
                        .map(note,GetAllNotesResponse.class)).collect(Collectors.toList());
        return noteResponses;
    }

    @Override
    public List<GetActiveNotesResponse> getActiveNotes() {
        List<Note> notes = noteRepository.findAllActive();
        List<GetActiveNotesResponse> noteResponses = notes.stream()
                .map(note->this.modelMapperService.forResponse()
                        .map(note,GetActiveNotesResponse.class)).collect(Collectors.toList());
        return noteResponses;
    }

    @Override
    public GetByIdNoteResponse getById(int id) {
        Note  note = noteRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Note not found"));
        GetByIdNoteResponse noteResponse = this.modelMapperService.forResponse()
                .map(note,GetByIdNoteResponse.class);
        return noteResponse;
    }

    @Override
    public void add(CreateNoteRequest createNoteRequest) {
        NoteValidationUtility.validateCreateNote(createNoteRequest);
        Note note = modelMapperService.forRequest()
                .map(createNoteRequest, Note.class);
        note.setCustomer(new Customer());
        note.getCustomer().setId(createNoteRequest.getCustomer());
        this.noteRepository.save(note);
    }

    @Override
    public void update(UpdateNoteRequest updateNoteRequest) {
        NoteValidationUtility.validateUpdateNote(updateNoteRequest);
        Note note = modelMapperService.forRequest()
                .map(updateNoteRequest, Note.class);
        this.noteRepository.save(note);
    }

    @Override
    public void delete(int id) {
        this.noteRepository.deleteById(id);
    }

    @Override
    public void softDeleteNote(int id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Note not found"));
        note.setActive(false);
        this.noteRepository.save(note);
    }
}
