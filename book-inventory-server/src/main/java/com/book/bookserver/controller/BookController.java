package com.book.bookserver.controller;

import com.book.bookserver.model.BookDetails;
import com.book.bookserver.service.BookDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookDetailsService bookService;

    @GetMapping(value = "/bookdeatils")
    public List<BookDetails> getAll() {

        LOG.info("entering getAll");
        List<BookDetails> all = this.bookService.getAll();
        LOG.info("exiting getAll " + all);
        return all;

    }

    @GetMapping(value = "/books/{id}")
    public BookDetails getOne(@PathVariable Integer id) {
        return this.bookService.getOne(id);
    }

}
