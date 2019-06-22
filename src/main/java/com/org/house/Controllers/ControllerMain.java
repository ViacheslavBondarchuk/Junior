package com.org.house.Controllers;

import com.org.house.DB.Entities.Contact;
import com.org.house.DB.Entities.Phone;
import com.org.house.DB.Resitory.ContactRepos;
import com.org.house.DB.Resitory.PhoneRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class ControllerMain {
    @Autowired
    private ContactRepos contactRepos;
    @Autowired
    private PhoneRepos phoneRepos;

    @GetMapping()
    public String getAllContacts(Map<String, Object> contactModel, Map<String, Object> phoneModel) {
        Iterable<Contact> contacts = contactRepos.findAll();
        Iterable<Phone> phones = phoneRepos.findAll();

        contactModel.put("Contacts", contacts);
        phoneModel.put("Phones", phones);

        return "main";
    }

    @PostMapping()
    public String createNewContact(@RequestParam String firstName, @RequestParam String lastName,
                                   @RequestParam String email, @RequestParam String phoneNumber,
                                   @RequestParam String operatorName) {
        Contact contact = new Contact(firstName, lastName, email, Collections.singletonList(new Phone(phoneNumber, operatorName)));
        contactRepos.save(contact);

        return "main";
    }


}
