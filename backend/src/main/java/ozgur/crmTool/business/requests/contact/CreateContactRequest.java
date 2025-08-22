package ozgur.crmTool.business.requests.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object for creating a new contact.
 * <p>
 * This DTO carries the data required to create a {@link ozgur.crmTool.entities.concretes.Contact}
 * and establish a relationship with an existing {@link ozgur.crmTool.entities.concretes.Customer}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactRequest {
    /**
     * The ID of the customer this contact belongs to.
     * <p>
     * Used to establish a relationship between the new contact and an existing customer.
     */
    private int customer;

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
     * The title of the contact person.
     */
    private String title;

    /**
     * The job position or role of the contact person within the customer organization.
     */
    private String position;

    /**
     * Preferred way of communication for the contact.
     */
    private String contactPreferences;

}
