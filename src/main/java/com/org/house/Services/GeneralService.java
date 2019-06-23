package com.org.house.Services;

import com.org.house.DB.Entities.Contact;
import com.org.house.DB.Entities.Phone;
import com.org.house.DB.Repository.ContactRepos;
import com.org.house.DB.Repository.PhoneRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class GeneralService {

    @Autowired
    private ContactRepos contactRepos;
    @Autowired
    private PhoneRepos phoneRepos;

    public Iterable<Contact> getAllContacts() {
        return contactRepos.findAll();
    }

    public Iterable<Phone> getAllPhones() {
        return phoneRepos.findAll();
    }

    public void addContact(String firstName, String lastName, String email,String number, String operatorName) {
        Contact contact = new Contact(firstName, lastName, email, Collections.singletonList(new Phone(number, operatorName)));
        contactRepos.save(contact);

        System.out.println("200OK");
    }

    @Transactional
    public void addPhone(String number, String operator, String email) {
        Phone phone = new Phone(number, operator);
        Contact contact = contactRepos.findByEmail(email);
        phone.setContact(contact);

        phoneRepos.save(phone);

        System.out.println("200OK");

    }

    public void updateContact(Contact contact) {
        contact.setId(contactRepos.findByEmail(contact.getEmail()).getId());
        contactRepos.saveAndFlush(contact);

        System.out.println("200OK");
    }

    public void updatePhone(Phone phone){
        phoneRepos.findById(phone.getId()).ifPresent(phone1 -> phone.setContact(phone1.getContact()));

        phoneRepos.saveAndFlush(phone);

        System.out.println("200OK");
    }

}

