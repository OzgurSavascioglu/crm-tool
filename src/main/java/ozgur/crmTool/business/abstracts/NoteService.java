package ozgur.crmTool.business.abstracts;

import ozgur.crmTool.business.requests.note.CreateNoteRequest;
import ozgur.crmTool.business.requests.note.UpdateNoteRequest;
import ozgur.crmTool.business.responses.note.GetActiveNotesResponse;
import ozgur.crmTool.business.responses.note.GetAllNotesResponse;
import ozgur.crmTool.business.responses.note.GetByIdNoteResponse;

import java.util.List;

public interface NoteService {
    List<GetAllNotesResponse> getAll();
    List<GetActiveNotesResponse> getActiveNotes();
    GetByIdNoteResponse getById(int id);
    void add(CreateNoteRequest createNoteRequest);
    void update(UpdateNoteRequest updateNoteRequest);
    void delete(int id);
    void softDeleteNote(int id);
}
