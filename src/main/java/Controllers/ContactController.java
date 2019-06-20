package Controllers;

import Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public void getAllContacts(){
        contactService.getAllContacts();
    }
    @PostMapping("/contact/create")
    public void createNewContact(){
        contactService.createNewContact();
    }

    @PatchMapping("/contact/update")
    public void updateContactDetails(){
        contactService.updateContactDetails();
    }

    @PostMapping("/phone/add")
    public void addPhoneNumber(){
        contactService.addPhoneNumber();
    }

    @PatchMapping("/phone/update")
    public void updatePhoneNumber(){
        contactService.updatePhoneNumber();
    }

}
