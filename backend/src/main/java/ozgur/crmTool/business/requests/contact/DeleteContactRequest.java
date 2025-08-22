package ozgur.crmTool.business.requests.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object for deleting a contact.
 * <p>
 * This DTO can be used to:
 * - Soft delete a contact by marking it as inactive.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteContactRequest {
    /**
     * The unique identifier of the contact to delete.
     */
    private int id;

    /**
     * Indicates whether the contact is active.
     * <p>
     * - If {@code true}, the contact remains active.
     * - If {@code false}, the contact is soft-deleted (marked inactive).
     */
    private boolean isActive;
}
