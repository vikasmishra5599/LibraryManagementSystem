package com.asssignment.LibraryManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailid;
    private String firstname;
    private String lastname;
    private String contactno;
    private ZonedDateTime createdtime;

    public User() {
    }

    public User(String emailid, String firstname, String lastname, String contactno, ZonedDateTime zonedDateTime) {
        this.emailid = emailid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.contactno = contactno;
        this.createdtime = createdtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public ZonedDateTime getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(ZonedDateTime createdtime) {
        this.createdtime = createdtime;
    }
}
