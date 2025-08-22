package ozgur.crmTool.business.abstracts;

import ozgur.crmTool.business.requests.note.CreateNoteRequest;
import ozgur.crmTool.business.requests.note.UpdateNoteRequest;
import ozgur.crmTool.business.responses.note.GetActiveNotesResponse;
import ozgur.crmTool.business.responses.note.GetAllNotesResponse;
import ozgur.crmTool.business.responses.note.GetByIdNoteResponse;

import java.util.List;

/**
 * Service interface for managing notes in the CRM tool.
 * Defines the contract for operations such as retrieval, creation, update,
 * deletion, and soft-deletion of notes.
 */
public interface NoteService {
    /**
     * Retrieves all notes from the system (both active and inactive).
     *
     * @return List of notes with detailed information.
     */
    List<GetAllNotesResponse> getAll();
    /**
     * Retrieves only the active notes (not soft-deleted).
     *
     * @return List of active notes.
     */
    List<GetActiveNotesResponse> getActiveNotes();
    /**
     * Retrieves a single note by its unique identifier.
     *
     * @param id The unique ID of the note to retrieve.
     * @return Note details wrapped in a response object.
     */
    GetByIdNoteResponse getById(int id);
    /**
     * Creates a new note based on the provided request data.
     *
     * @param createNoteRequest Request object containing note creation details.
     */
    void add(CreateNoteRequest createNoteRequest);
    /**
     * Updates an existing note with the provided request data.
     *
     * @param updateNoteRequest Request object containing note update details.
     */
    void update(UpdateNoteRequest updateNoteRequest);
    /**
     * Permanently deletes a note from the system by its ID.
     *
     * @param id The unique ID of the note to delete.
     */
    void delete(int id);
    /**
     * Performs a soft delete on a note (marks it as inactive instead of permanent removal).
     *
     * @param id The unique ID of the note to soft-delete.
     */
    void softDeleteNote(int id);
}
