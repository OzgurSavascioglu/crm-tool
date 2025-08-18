package ozgur.crmTool.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ozgur.crmTool.business.abstracts.ContactService;
import ozgur.crmTool.business.requests.contact.CreateContactRequest;
import ozgur.crmTool.business.requests.contact.UpdateContactRequest;
import ozgur.crmTool.business.responses.contact.GetActiveContactsResponse;
import ozgur.crmTool.business.responses.contact.GetAllContactsResponse;
import ozgur.crmTool.business.responses.contact.GetByIdContactResponse;

import java.util.List;

/**
 * REST controller for managing contact-related operations.
 * <p>
 * Provides endpoints for retrieving, creating, updating, and deleting contacts.
 */
@RestController
@RequestMapping("/api/contacts")
public class ContactsController {
    private ContactService contactService;

    /**
     * Constructor-based injection of {@link ContactService}.
     *
     * @param contactService the contact service implementation
     */
    @Autowired
    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * Retrieves all contacts.
     *
     * @return list of all contacts
     */
    @GetMapping("/getAll")
    public List<GetAllContactsResponse> getAll(){
        return contactService.getAll();
    }

    /**
     * Retrieves only active contacts.
     *
     * @return list of active contacts
     */
    @GetMapping("/getActiveContacts")
    public List<GetActiveContactsResponse> getActiveContacts(){
        return contactService.getActiveContacts();
    }

    /**
     * Retrieves a contact by its unique identifier.
     *
     * @param id the ID of the contact
     * @return details of the contact
     */
    @GetMapping("/getById/{id}")
    public GetByIdContactResponse getById(@PathVariable int id){
        return contactService.getById(id);
    }

    /**
     * Creates a new contact.
     *
     * @param createContactRequest DTO containing new contact details
     */
    @PostMapping("/add")
    public void add(CreateContactRequest createContactRequest){
        this.contactService.add(createContactRequest);
    }

    /**
     * Updates an existing contact.
     *
     * @param updateContactRequest DTO containing updated contact details
     */
    @PutMapping("/update")
    public void update(UpdateContactRequest updateContactRequest){
        this.contactService.update(updateContactRequest);
    }

    /**
     * Permanently deletes a contact.
     *
     * @param id the ID of the contact to delete
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.contactService.delete(id);
    }

    /**
     * Soft deletes a contact (marks it as inactive instead of removing it).
     *
     * @param id the ID of the contact to soft delete
     */
    @DeleteMapping("/softDelete/{id}")
    public void softDelete(@PathVariable int id){
        this.contactService.softDeleteContact(id);
    }

}
