package ozgur.crmTool.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ozgur.crmTool.business.abstracts.NoteService;
import ozgur.crmTool.business.requests.note.CreateNoteRequest;
import ozgur.crmTool.business.requests.note.UpdateNoteRequest;
import ozgur.crmTool.business.responses.note.GetActiveNotesResponse;
import ozgur.crmTool.business.responses.note.GetAllNotesResponse;
import ozgur.crmTool.business.responses.note.GetByIdNoteResponse;

import java.util.List;

/**
 * REST controller for managing notes in the CRM system.
 * Provides endpoints for CRUD operations and soft delete.
 */
@RestController
@RequestMapping("/api/notes")
public class NotesController {
    // Business layer dependency (service for handling note operations)
    private NoteService noteService;

    /**
     * Constructor-based dependency injection for NoteService.
     *
     * @param noteService Service for managing notes
     */
    @Autowired
    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * Retrieves all notes (both active and inactive).
     *
     * @return List of GetAllNotesResponse DTOs
     */
    @GetMapping("/getAll")
    public List<GetAllNotesResponse> getAll() {
        return noteService.getAll();
    }

    /**
     * Retrieves only active notes.
     *
     * @return List of GetActiveNotesResponse DTOs
     */
    @GetMapping("/getActiveNotes")
    public List<GetActiveNotesResponse> getActiveNotes() {
        return noteService.getActiveNotes();
    }

    /**
     * Retrieves a note by its ID.
     *
     * @param id Note ID (passed as a path variable)
     * @return GetByIdNoteResponse DTO
     */
    @GetMapping("/getById/{id}")
    public GetByIdNoteResponse getById(@PathVariable int id) {
        return noteService.getById(id);
    }

    /**
     * Creates a new note.
     *
     * @param createNoteRequest DTO containing note details
     */
    @PostMapping("/add")
    public void add(CreateNoteRequest createNoteRequest){
        this.noteService.add(createNoteRequest);
    }

    /**
     * Updates an existing note.
     *
     * @param updateNoteRequest DTO containing updated note details
     */
    @PutMapping("/update")
    public void update(UpdateNoteRequest updateNoteRequest){
        this.noteService.update(updateNoteRequest);
    }

    /**
     * Permanently deletes a note by ID.
     *
     * @param id Note ID
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.noteService.delete(id);
    }

    /**
     * Soft deletes a note by setting isActive = false.
     *
     * @param id Note ID
     */
    @DeleteMapping("/softDelete/{id}")
    public void softDelete(@PathVariable int id) {
        this.noteService.softDeleteNote(id);
    }
}
