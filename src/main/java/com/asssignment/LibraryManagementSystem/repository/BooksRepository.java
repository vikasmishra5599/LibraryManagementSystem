package com.asssignment.LibraryManagementSystem.repository;

import com.asssignment.LibraryManagementSystem.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Book, Long> {
    Book findByName(String bookname);
}
