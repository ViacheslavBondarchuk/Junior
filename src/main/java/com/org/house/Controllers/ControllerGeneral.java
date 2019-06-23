package com.org.house.Controllers;


import com.org.house.DB.Entities.Contact;
import com.org.house.DB.Entities.Phone;
import com.org.house.Services.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ControllerGeneral {
    @Autowired
    private GeneralService service;

    @GetMapping("/")
    public String getPageMain(Map<String, Object> contactModel, Map<String, Object> phoneModel) {
        contactModel.put("Contacts", service.getAllContacts());
        phoneModel.put("Phones", service.getAllPhones());

        return "main";
    }

    @GetMapping("/contacts")
    public String getPageContacts(Map<String, Object> contactModel) {
        contactModel.put("Contacts", service.getAllContacts());

        return "contact";
    }

    @GetMapping("/phones")
    public String getPagePhones(Map<String, Object> phoneModel) {
        phoneModel.put("Phones", service.getAllPhones());

        return "phone";
    }

    @PostMapping(value = {"/contacts"})
    public String createContact(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam String email, @RequestParam String number,
                                @RequestParam String operatorName) {
        service.addContact(firstName, lastName, email, number, operatorName);

        return "contact";
    }

    @PostMapping(value = {"/phones"})
    public String addPhone(@RequestParam String number, @RequestParam String operatorName, @RequestParam String email){
        service.addPhone(number,operatorName,email);

        return "phone";
    }

    @PatchMapping(value = "/contacts/update")
    public String updateContact(@RequestBody Contact contact) {
        service.updateContact(contact);

        return "contact";
    }

    @PatchMapping(value = "/phones/update")
    public String updatePhone(@RequestBody Phone phone) {
        service.updatePhone(phone);

        return "phone";
    }


}
