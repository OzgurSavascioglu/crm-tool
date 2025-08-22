package ozgur.crmTool.business.responses.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) used to return a note by id
 * from the system.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdNoteResponse {
    /**
     * Unique identifier for the note.
     */
    private int id;

    /**
     * The ID of the customer that this note is associated with.
     */
    private int customerId;

    /**
     * The actual text/content of the note.
     */
    private String content;

    /**
     * The author who created the note.
     */
    private String author;

    /**
     * Flag indicating whether the note is active (true) or
     * soft-deleted/inactive (false).
     */
    private boolean isActive;
}
