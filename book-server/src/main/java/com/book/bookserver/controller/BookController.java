package com.book.bookserver.controller;

import com.book.bookserver.dto.BookResponse;
import com.book.bookserver.model.Book;
import com.book.bookserver.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/books")
    public List<BookResponse> getAll() {
        LOG.info("entering getAll");
        List<Book> books = this.bookService.getAll();
        List<BookResponse> bookResponses = new ArrayList<>();
        for (Book book : books) {
            bookResponses.add(new BookResponse(book.getId(), book.getIsbn(), book.getTitle(), book.getYear()));
        }
        LOG.info("exiting getAll " + bookResponses);
        return bookResponses;
    }

    @GetMapping(value = "/books/{id}")
    public BookResponse getOne(@PathVariable Integer id) {
        Book book = this.bookService.getOne(id);
        return new BookResponse(book.getId(), book.getIsbn(), book.getTitle(), book.getYear());
    }

}
