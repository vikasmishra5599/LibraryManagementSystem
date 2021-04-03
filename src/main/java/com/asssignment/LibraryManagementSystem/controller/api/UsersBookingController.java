package com.asssignment.LibraryManagementSystem.controller.api;

import com.asssignment.LibraryManagementSystem.domain.BookingDetail;
import com.asssignment.LibraryManagementSystem.entity.UsersBooking;
import com.asssignment.LibraryManagementSystem.service.UsersBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/booking")
public class UsersBookingController {
    private static final Logger LOG = LoggerFactory.getLogger(UsersBookingController.class);
    private final UsersBookingService usersBookingService;

    @Autowired
    public UsersBookingController(UsersBookingService usersBookingService) {
        this.usersBookingService = usersBookingService;
    }

    @GetMapping(value = "/user/{username}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity showUsersBookingDetail(@PathVariable final String username) {
        List<UsersBooking> usersBooking = usersBookingService.findBookingDetailsForUser(username);
        return ResponseEntity.ok(usersBooking);
    }

    @GetMapping(value = "/book/{bookname}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity showBooksBookingDetail(@PathVariable final String bookname) {
        List<UsersBooking> usersBooking = usersBookingService.findBookingDetailsForBook(bookname);
        return ResponseEntity.ok(usersBooking);
    }

    @PostMapping("/book")
    public ResponseEntity makeBooking(@RequestBody @NotNull BookingDetail bookingDetail) {
        LOG.info("User borrowed book");
        usersBookingService.borrowBook(bookingDetail);
        return ResponseEntity.status(CREATED).build();
    }

    @PostMapping("/return")
    public ResponseEntity returnBook(@RequestBody @NotNull BookingDetail bookingDetail) {
        LOG.info("User going to return book [{}]", bookingDetail);
        usersBookingService.returnBook(bookingDetail);
        return ResponseEntity.ok().build();
    }
}