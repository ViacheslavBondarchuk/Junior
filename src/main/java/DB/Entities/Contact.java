package DB.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contact")
    private List<Phone> phoneList = new ArrayList<Phone>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public Contact() {
    }

    public Contact(String firstName, String lastName, String email, List<Phone> phoneList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneList = phoneList;
    }
}
