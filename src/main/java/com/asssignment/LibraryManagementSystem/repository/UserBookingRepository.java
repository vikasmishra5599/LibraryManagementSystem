package com.asssignment.LibraryManagementSystem.repository;

import com.asssignment.LibraryManagementSystem.entity.UsersBooking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBookingRepository extends CrudRepository<UsersBooking, Long> {

    @Query("select u from usersbooking u where u.userId = ?1")
    List<UsersBooking> findByUserid(Long userId);

    @Query("select u from usersbooking u where u.userId in (select id from users where emailid = ?1 ) and u.bookId in (select id from books where name = ?2 )")
     List<UsersBooking> findByUserNameAndBookName(String username, String bookname);
}
