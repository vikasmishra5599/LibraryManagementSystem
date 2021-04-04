package com.asssignment.LibraryManagementSystem.controller.api;

import com.asssignment.LibraryManagementSystem.domain.BookDetail;
import com.asssignment.LibraryManagementSystem.entity.Book;
import com.asssignment.LibraryManagementSystem.service.BooksService;
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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/book")
public class BooksController {
    private static final Logger LOG = LoggerFactory.getLogger(BooksController.class);
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping("")
    public ResponseEntity addBook(@RequestBody @Valid BookDetail bookDetail) {
        long bookId = booksService.createBook(bookDetail);
        LOG.info("Added book with id [{}] created successfully", bookId);
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity showAllBooks() {
        LOG.info("Request to retrieve all book details received");
        List<Book> books = booksService.fetchAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping(value = "/{bookname}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity getBookDetail(@PathVariable @NotNull final String bookname) {
        return ResponseEntity.ok(booksService.findByBookId(bookname));
    }
}
