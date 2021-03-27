package com.asssignment.LibraryManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {

    @Id
    private Long id;
    private String name;
    private String author;
    private String publishyear;
    private int availablecount;
    private int issuedcount;

    public Books() {
    }

    public Books(String name, String author, String publishyear, int availablecount, int issuedcount) {
        this.name = name;
        this.author = author;
        this.publishyear = publishyear;
        this.availablecount = availablecount;
        this.issuedcount = issuedcount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAvailablecount() {
        return availablecount;
    }

    public void setAvailablecount(int availablecount) {
        this.availablecount = availablecount;
    }

    public int getIssuedcount() {
        return issuedcount;
    }

    public void setIssuedcount(int issuedcount) {
        this.issuedcount = issuedcount;
    }
}
