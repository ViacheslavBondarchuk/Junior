package com.org.house.DB.Entities;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String number;
    @Column
    private String operatorName;

    @JoinColumn(name = "contact_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Phone() {
    }

    public Phone(String number, String operatorName) {
        this.number = number;
        this.operatorName = operatorName;
    }
}
