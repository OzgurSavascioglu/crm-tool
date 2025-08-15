package ozgur.crmTool.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ozgur.crmTool.business.abstracts.ContactService;
import ozgur.crmTool.business.requests.contact.CreateContactRequest;
import ozgur.crmTool.business.requests.contact.UpdateContactRequest;
import ozgur.crmTool.business.responses.contact.GetActiveContactsResponse;
import ozgur.crmTool.business.responses.contact.GetAllContactsResponse;
import ozgur.crmTool.business.responses.contact.GetByIdContactResponse;
import ozgur.crmTool.entities.concretes.Contact;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/getAll")
    public List<GetAllContactsResponse> getAll(){
        return contactService.getAll();
    }

    @GetMapping("/getActiveContacts")
    public List<GetActiveContactsResponse> getActiveContacts(){
        return contactService.getActiveContacts();
    }

    @GetMapping("/getById/{id}")
    public GetByIdContactResponse getById(@PathVariable int id){
        return contactService.getById(id);
    }

    @PostMapping("/add")
    public void add(CreateContactRequest createContactRequest){
        this.contactService.add(createContactRequest);
    }

    @PutMapping("/update")
    public void update(UpdateContactRequest updateContactRequest){
        this.contactService.update(updateContactRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.contactService.delete(id);
    }

    @DeleteMapping("/softDelete/{id}")
    public void softDelete(@PathVariable int id){
        this.contactService.softDeleteContact(id);
    }


}
