package com.asssignment.LibraryManagementSystem.domain;

public class BookingDetail {
    private String username;
    private String bookname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public String toString() {
        return "BookingDetail{" +
                "username='" + username + '\'' +
                ", bookname='" + bookname + '\'' +
                '}';
    }
}
