package ozgur.crmTool.business.abstracts;

import ozgur.crmTool.business.requests.contact.CreateContactRequest;
import ozgur.crmTool.business.requests.contact.UpdateContactRequest;
import ozgur.crmTool.business.responses.contact.GetActiveContactsResponse;
import ozgur.crmTool.business.responses.contact.GetByIdContactResponse;
import ozgur.crmTool.business.responses.customer.GetActiveCustomersResponse;
import ozgur.crmTool.business.responses.contact.GetAllContactsResponse;

import java.util.List;

public interface ContactService {
    List<GetAllContactsResponse> getAll();
    List<GetActiveContactsResponse> getActiveContacts();
    GetByIdContactResponse getById(int id);
    void add(CreateContactRequest createContactRequest);
    void update(UpdateContactRequest updateContactRequest);
    void delete(int id);
    void softDeleteContact(int id);

}
