package ozgur.crmTool.business.responses.note;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ozgur.crmTool.entities.concretes.Customer;

/**
 * DTO (Data Transfer Object) used to return all Notes
 * from the system when fetching them.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllNotesResponse {
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
