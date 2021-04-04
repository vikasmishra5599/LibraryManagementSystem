package com.asssignment.LibraryManagementSystem.service;

import com.asssignment.LibraryManagementSystem.domain.BookingDetail;
import com.asssignment.LibraryManagementSystem.entity.Book;
import com.asssignment.LibraryManagementSystem.entity.User;
import com.asssignment.LibraryManagementSystem.entity.UsersBooking;
import com.asssignment.LibraryManagementSystem.exception.NotFoundException;
import com.asssignment.LibraryManagementSystem.repository.BooksRepository;
import com.asssignment.LibraryManagementSystem.repository.UserBookingRepository;
import com.asssignment.LibraryManagementSystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersBookingService {
    private static final Logger LOG = LoggerFactory.getLogger(UsersBookingService.class);
    private final UserBookingRepository userBookingRepository;
    private final UserRepository userRepository;
    private final BooksRepository booksRepository;

    @Autowired
    public UsersBookingService(UserBookingRepository userBookingRepository,
                               UserRepository userRepository,
                               BooksRepository booksRepository) {
        this.userBookingRepository = userBookingRepository;
        this.userRepository = userRepository;
        this.booksRepository = booksRepository;
    }

    public List<UsersBooking> findBookingDetailsForUser(String username) {
        User userdetail = userRepository.findByEmailid(username);
        return userBookingRepository.findByUserid(userdetail.getId());
    }

    public List<UsersBooking> findBookingDetailsForBook(String bookname) {
        try {
            Book book = booksRepository.findByName(bookname);
            return userBookingRepository.findByUserid(book.getId());
        } catch (Exception e) {
            throw new NotFoundException("Failed to find bookinng info for books", e);
        }
    }

    public void borrowBook(BookingDetail bookingDetail) {
        try {
            Book book = booksRepository.findByName(bookingDetail.getBookname());
            User user = userRepository.findByEmailid(bookingDetail.getUsername());
            userBookingRepository.save(new UsersBooking(user.getId(), book.getId()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to register book for user", e);
        }
    }

    public void returnBook(BookingDetail bookingDetail) {
        try {
            List<UsersBooking> byUserNameAndBookName = userBookingRepository.findByUserNameAndBookName(bookingDetail.getUsername(), bookingDetail.getBookname());

            for (UsersBooking usersBooking : byUserNameAndBookName) {
                userBookingRepository.deleteById(usersBooking.getId());
            }
        } catch (Exception e) {
            throw new NotFoundException("Failed to find booking info for books", e);
        }
    }
}
