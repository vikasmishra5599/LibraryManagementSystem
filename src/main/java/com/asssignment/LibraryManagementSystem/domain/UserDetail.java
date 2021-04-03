package com.asssignment.LibraryManagementSystem.domain;

import javax.validation.constraints.NotBlank;

public class UserDetail {
    @NotBlank(message = "Email is mandatory")
    private String emailid;
    private String firstname;
    private String lastname;
    @NotBlank(message = "contact no is mandatory")
    private String contactno;

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
}
