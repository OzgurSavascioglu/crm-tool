package ozgur.crmTool.business.concretes;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ozgur.crmTool.business.abstracts.ContactService;
import ozgur.crmTool.business.requests.contact.CreateContactRequest;
import ozgur.crmTool.business.requests.contact.UpdateContactRequest;
import ozgur.crmTool.business.responses.contact.GetActiveContactsResponse;
import ozgur.crmTool.business.responses.contact.GetAllContactsResponse;
import ozgur.crmTool.business.responses.contact.GetByIdContactResponse;
import ozgur.crmTool.core.utilities.exception.NotFoundException;
import ozgur.crmTool.core.utilities.mappers.ModelMapperService;
import ozgur.crmTool.core.utilities.validation.ContactValidationUtility;
import ozgur.crmTool.dataAccess.abstracts.ContactRepository;
import ozgur.crmTool.dataAccess.abstracts.CustomerRepository;
import ozgur.crmTool.entities.concretes.Contact;
import ozgur.crmTool.entities.concretes.Customer;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Implementation of the {@link ContactService} interface.
 * <p>
 * Handles business logic related to Contact management, including CRUD operations,
 * soft deletion, and custom queries (e.g., active contacts).
 * <p>
 * Uses:
 * - {@link ContactRepository} for persistence operations
 * - {@link ModelMapperService} for mapping between entities and DTOs
 * - {@link ContactValidationUtility} for validating incoming requests
 */
@Service
@AllArgsConstructor
public class ContactManager implements ContactService {
    private ContactRepository contactRepository;
    private ModelMapperService modelMapperService;

    /**
     * Retrieves all contacts in the system.
     *
     * @return a list of DTOs representing all contacts
     */
    @Override
    @Transactional
    public List<GetAllContactsResponse> getAll() {
        List<Contact> contacts = contactRepository.findAll();
        List<GetAllContactsResponse> contactResponse = contacts.stream()
                .map(contact->this.modelMapperService.forResponse()
                        .map(contact, GetAllContactsResponse.class)).collect(Collectors.toList());
        return contactResponse;
    }

    /**
     * Retrieves all active contacts.
     *
     * @return a list of DTOs representing active contacts
     */
    @Override
    public List<GetActiveContactsResponse> getActiveContacts() {
        List<Contact> contacts = contactRepository.findAllActive();
        List<GetActiveContactsResponse> contactResponse = contacts.stream()
                .map(contact->this.modelMapperService.forResponse()
                        .map(contact, GetActiveContactsResponse.class)).collect(Collectors.toList());
        return contactResponse;
    }

    /**
     * Finds a contact by its ID.
     *
     * @param id the contact ID
     * @return DTO with the contact details
     * @throws NotFoundException if no contact with the given ID exists
     */
    @Override
    public GetByIdContactResponse getById(int id) {
        Contact  contact = this.contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
        GetByIdContactResponse contactResponse = this.modelMapperService.forResponse()
                .map(contact, GetByIdContactResponse.class);
        return contactResponse;
    }

    /**
     * Adds a new contact to the system.
     * <p>
     * - Validates the request
     * - Maps request DTO to entity
     * - Links contact to a customer by ID
     *
     * @param createContactRequest DTO containing contact details
     */
    @Override
    public void add(CreateContactRequest createContactRequest) {
        ContactValidationUtility.validateCreateContact(createContactRequest);
        Contact contact = modelMapperService.forRequest()
                .map(createContactRequest, Contact.class);
        contact.setCustomer(new Customer());
        contact.getCustomer().setId(createContactRequest.getCustomer());
        this.contactRepository.save(contact);
    }

    /**
     * Updates an existing contact.
     * <p>
     * - Validates the request
     * - Maps request DTO to entity
     *
     * @param updateContactRequest DTO with updated contact information
     */
    @Override
    public void update(UpdateContactRequest updateContactRequest) {
        ContactValidationUtility.validateUpdateContact(updateContactRequest);
        Contact contact = modelMapperService.forRequest()
                .map(updateContactRequest, Contact.class);
        this.contactRepository.save(contact);
    }

    /**
     * Permanently deletes a contact from the system by ID.
     *
     * @param id the contact ID
     */
    @Override
    public void delete(int id) {
        this.contactRepository.deleteById(id);
    }

    /**
     * Soft deletes a contact by marking it as inactive.
     *
     * @param id the contact ID
     * @throws NotFoundException if the contact does not exist
     */
    @Override
    public void softDeleteContact(int id) {
        Contact contact = this.contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contact not found"));
        contact.setActive(false);
        this.contactRepository.save(contact);
    }

}
