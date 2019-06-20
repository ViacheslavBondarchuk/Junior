package Service;

import DAO.ContactDAO;
import DB.Entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class ContactService {
    @Autowired
    private ContactDAO contact;


    public Collection<Contact> getAllContacts() {

        return contact.getAllContacts();
    }

    public Collection<Contact> createNewContact() {

        return contact.createNewContact();
    }

    public Collection<Contact> updateContactDetails() {

        return contact.updateContactDetails();
    }

    public Collection<Contact> addPhoneNumber() {

        return contact.addPhoneNumber();
    }

    public Collection<Contact>updatePhoneNumber() {

        return contact.updatePhoneNumber();
    }
}
