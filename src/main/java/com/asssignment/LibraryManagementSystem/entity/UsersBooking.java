package com.asssignment.LibraryManagementSystem.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UsersBooking {

    @EmbeddedId
    private BookingId bookingId;
    private boolean borrowedstatus;
    private boolean returnedstatus;

    public UsersBooking() {
    }

    public UsersBooking(BookingId bookingId, boolean borrowedstatus, boolean returnedstatus) {
        this.bookingId = bookingId;
        this.borrowedstatus = borrowedstatus;
        this.returnedstatus = returnedstatus;
    }

    public BookingId getBookingId() {
        return bookingId;
    }

    public void setBookingId(BookingId bookingId) {
        this.bookingId = bookingId;
    }

    public boolean isBorrowedstatus() {
        return borrowedstatus;
    }

    public void setBorrowedstatus(boolean borrowedStatus) {
        this.borrowedstatus = borrowedStatus;
    }

    public boolean isReturnedstatus() {
        return returnedstatus;
    }

    public void setReturnedstatus(boolean returnedstatus) {
        this.returnedstatus = returnedstatus;
    }
}
