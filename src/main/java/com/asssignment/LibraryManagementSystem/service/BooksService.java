package com.asssignment.LibraryManagementSystem.service;

import com.asssignment.LibraryManagementSystem.domain.BookDetail;
import com.asssignment.LibraryManagementSystem.entity.Book;
import com.asssignment.LibraryManagementSystem.exception.FetchFailureException;
import com.asssignment.LibraryManagementSystem.exception.NotFoundException;
import com.asssignment.LibraryManagementSystem.repository.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {
    private static final Logger LOG = LoggerFactory.getLogger(BooksService.class);
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> fetchAll() {
        List<Book> result = new ArrayList();
        try {
            booksRepository.findAll().forEach(result::add);
            return result;
        } catch (Exception e) {
            LOG.warn("failed to fetch books list", e);
            throw new FetchFailureException("Failed to fetch books", e);
        }
    }

    public Book findByBookId(String bookname) {
        try {
            return booksRepository.findByName(bookname);
        } catch (Exception e) {
            throw new NotFoundException("Failed to fetch book with name", e);
        }
    }

    public long createBook(BookDetail bookDetail) {
        Book book = mapToBook(bookDetail);
        Book save = booksRepository.save(book);
        return save.getId();
    }

    private Book mapToBook(BookDetail bookDetail) {
        return new Book(bookDetail.getName(), bookDetail.getAuthor(), bookDetail.getPublishyear(),
                bookDetail.getAvailablecount(), bookDetail.getIssuedcount());
    }
}
