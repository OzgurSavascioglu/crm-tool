package ozgur.crmTool.business.requests.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) class used when deleting a Note.
 * This class is part of the request layer, responsible for
 * receiving data from the client side.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteNoteRequest {
    /**
     * Unique identifier for the note.
     */
    private int id;
    /**
     * Flag indicating whether the note is active (true) or
     * soft-deleted/inactive (false).
     */
    private boolean isActive;
}
