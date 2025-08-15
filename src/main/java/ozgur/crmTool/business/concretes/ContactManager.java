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
import ozgur.crmTool.business.responses.customer.GetActiveCustomersResponse;
import ozgur.crmTool.business.responses.customer.GetByIDCustomerResponse;
import ozgur.crmTool.core.utilities.exception.NotFoundException;
import ozgur.crmTool.core.utilities.mappers.ModelMapperService;
import ozgur.crmTool.dataAccess.abstracts.ContactRepository;
import ozgur.crmTool.entities.concretes.Contact;
import ozgur.crmTool.entities.concretes.Customer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactManager implements ContactService {
    private ContactRepository contactRepository;
    private ModelMapperService modelMapperService;

    @Override
    @Transactional
    public List<GetAllContactsResponse> getAll() {
        List<Contact> contacts = contactRepository.findAll();
        List<GetAllContactsResponse> contactResponse = contacts.stream()
                .map(contact->this.modelMapperService.forResponse()
                        .map(contact, GetAllContactsResponse.class)).collect(Collectors.toList());
        return contactResponse;
    }

    @Override
    public List<GetActiveContactsResponse> getActiveContacts() {
        List<Contact> contacts = contactRepository.findAllActive();
        List<GetActiveContactsResponse> contactResponse = contacts.stream()
                .map(contact->this.modelMapperService.forResponse()
                        .map(contact, GetActiveContactsResponse.class)).collect(Collectors.toList());
        return contactResponse;
    }

    @Override
    public GetByIdContactResponse getById(int id) {
        Contact  contact = this.contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
        GetByIdContactResponse contactResponse = this.modelMapperService.forResponse()
                .map(contact, GetByIdContactResponse.class);
        return contactResponse;
    }

    @Override
    public void add(CreateContactRequest createContactRequest) {
        Contact contact = modelMapperService.forRequest()
                .map(createContactRequest, Contact.class);
        contact.setCustomer(new Customer());
        contact.getCustomer().setId(createContactRequest.getCustomer());
        this.contactRepository.save(contact);
    }

    @Override
    public void update(UpdateContactRequest updateContactRequest) {
        Contact contact = modelMapperService.forRequest()
                .map(updateContactRequest, Contact.class);
        this.contactRepository.save(contact);
    }

    @Override
    public void delete(int id) {
        this.contactRepository.deleteById(id);
    }

    @Override
    public void softDeleteContact(int id) {
        Contact contact = this.contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contact not found"));
        contact.setActive(false);
        this.contactRepository.save(contact);
    }

}
