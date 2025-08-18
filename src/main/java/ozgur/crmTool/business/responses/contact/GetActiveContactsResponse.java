package ozgur.crmTool.business.responses.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response object representing an active contact.
 * <p>
 * Returned when querying active contacts from the system.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetActiveContactsResponse {
    /**
     * The unique identifier of the contact.
     */
    private int id;

    /**
     * The ID of the customer this contact belongs to.
     */
    private int customerId;

    /**
     * The full name of the contact person.
     */
    private String name;

    /**
     * The phone number of the contact person.
     */
    private String phone;

    /**
     * The email address of the contact person.
     */
    private String email;

    /**
     * The title or honorific of the contact person (e.g., Mr., Ms., Dr.).
     */
    private String title;

    /**
     * Job position or role within the company.
     */
    private String position;

    /**
     * Preferred communication methods and notes.
     * Free-text field for special instructions about
     * how and when to contact this person.
     */
    private String contactPreferences;

    /**
     * Active status flag indicating whether this contact
     * is currently engaged with the company.
     */
    private boolean isActive;
}
