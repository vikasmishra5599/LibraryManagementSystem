package com.asssignment.LibraryManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name= "usersbooking")
public class UsersBooking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="userid")
    private Long userId;
    @Column(name ="bookid")
    private Long bookId;

    public UsersBooking() {
    }

    public UsersBooking(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
     }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
