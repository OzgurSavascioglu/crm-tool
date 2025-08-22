package ozgur.crmTool.business.abstracts;

import ozgur.crmTool.business.requests.contact.CreateContactRequest;
import ozgur.crmTool.business.requests.contact.UpdateContactRequest;
import ozgur.crmTool.business.responses.contact.GetActiveContactsResponse;
import ozgur.crmTool.business.responses.contact.GetByIdContactResponse;
import ozgur.crmTool.business.responses.contact.GetAllContactsResponse;

import java.util.List;

/**
 * Service interface for managing contact-related business operations.
 * Defines the core CRUD operations and custom queries for contacts.
 */
public interface ContactService {

    /**
     * Retrieves all contacts from the system.
     *
     * @return a list of all contacts as DTOs
     */
    List<GetAllContactsResponse> getAll();

    /**
     * Retrieves only the active contacts from the system.
     *
     * @return a list of active contacts as DTOs
     */
    List<GetActiveContactsResponse> getActiveContacts();

    /**
     * Retrieves a specific contact by its unique identifier.
     *
     * @param id the unique ID of the contact
     * @return the contact details as a DTO
     */
    GetByIdContactResponse getById(int id);

    /**
     * Creates a new contact in the system.
     *
     * @param createContactRequest the request DTO containing contact details
     */
    void add(CreateContactRequest createContactRequest);

    /**
     * Updates an existing contact's information.
     *
     * @param updateContactRequest the request DTO containing updated contact details
     */
    void update(UpdateContactRequest updateContactRequest);

    /**
     * Permanently deletes a contact from the system.
     *
     * @param id the unique ID of the contact to delete
     */
    void delete(int id);

    /**
     * Soft deletes a contact by marking it as inactive (instead of permanent removal).
     *
     * @param id the unique ID of the contact to soft delete
     */
    void softDeleteContact(int id);

}
