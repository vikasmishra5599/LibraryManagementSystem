package com.asssignment.LibraryManagementSystem.entity;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingId bookingId = (BookingId) o;
        return Objects.equals(userId, bookingId.userId) && Objects.equals(bookId, bookingId.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookId);
    }
}
