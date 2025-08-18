package ozgur.crmTool.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ozgur.crmTool.business.abstracts.NoteService;
import ozgur.crmTool.business.requests.note.CreateNoteRequest;
import ozgur.crmTool.business.requests.note.UpdateNoteRequest;
import ozgur.crmTool.business.responses.note.GetActiveNotesResponse;
import ozgur.crmTool.business.responses.note.GetAllNotesResponse;
import ozgur.crmTool.business.responses.note.GetByIdNoteResponse;
import ozgur.crmTool.entities.concretes.Note;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    private NoteService noteService;

    @Autowired
    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/getAll")
    public List<GetAllNotesResponse> getAll() {
        return noteService.getAll();
    }

    @GetMapping("/getActiveNotes")
    public List<GetActiveNotesResponse> getActiveNotes() {
        return noteService.getActiveNotes();
    }

    @GetMapping("/getById/{id}")
    public GetByIdNoteResponse getById(@PathVariable int id) {
        return noteService.getById(id);
    }

    @PostMapping("/add")
    public void add(CreateNoteRequest createNoteRequest){
        this.noteService.add(createNoteRequest);
    }

    @PutMapping("/update")
    public void update(UpdateNoteRequest updateNoteRequest){
        this.noteService.update(updateNoteRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.noteService.delete(id);
    }

    @DeleteMapping("/softDelete/{id}")
    public void softDelete(@PathVariable int id) {
        this.noteService.softDeleteNote(id);
    }
}
