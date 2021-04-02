package com.asssignment.LibraryManagementSystem.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookingId implements Serializable {

    private Long userId;
    private Long bookId;

    public BookingId() {
    }

    public BookingId(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
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
