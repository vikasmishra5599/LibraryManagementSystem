package com.asssignment.LibraryManagementSystem.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookDetail {
    @NotBlank(message = "book name is mandatory")
    private String name;
    private String author;
    private String publishyear;
    @NotNull(message = "books available count is required")
    private int availablecount;
    private int issuedcount;

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
