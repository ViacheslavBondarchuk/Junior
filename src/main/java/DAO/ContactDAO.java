package DAO;

import DB.Entities.Contact;
import DB.HUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public class ContactDAO {
    @Autowired
    HibernateUtil hibernateUtil;

    public Collection<Contact> getAllContacts() {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("from Contact join Phone ");
            List contacts = query.list();

            return contacts;
        }
    }

    public String createNewContact() {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("insert into Contact (firstName,lastName,email,phoneList)");

            return "200OK";
        }
    }

    public String updateContactDetails() {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("update Contact where id = contact_id");

        }
    }

    public Collection<Contact> addPhoneNumber() {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("insert into Phone.")


        }
    }

    public Collection<Contact>updatePhoneNumber() {
        try (Session session = HibernateUtil.getSession()) {



        }
    }

}
