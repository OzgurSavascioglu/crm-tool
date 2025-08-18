package ozgur.crmTool.business.requests.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) class used when creating a new Note.
 * This class is part of the request layer, responsible for
 * receiving data from the client side.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteRequest {
    /**
     * The ID of the customer this note belongs to.
     * It will be used to associate the note with a specific customer.
     */
    private int customer;
    /**
     * The main body/content of the note.
     */
    private String content;
    /**
     * The name or identifier of the author who created the note.
     */
    private String author;
}
