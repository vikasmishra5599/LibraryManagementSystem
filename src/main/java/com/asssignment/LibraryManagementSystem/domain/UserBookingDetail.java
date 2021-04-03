package com.asssignment.LibraryManagementSystem.domain;

public class UserBookingDetail {
    private String emailid;
    private String firstname;
    private String lastname;
    private String contactno;
    private String bookname;
    private String author;
    private String publishyear;
    private int issuedcount;

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

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(String publishyear) {
        this.publishyear = publishyear;
    }

    public int getIssuedcount() {
        return issuedcount;
    }

    public void setIssuedcount(int issuedcount) {
        this.issuedcount = issuedcount;
    }
}
