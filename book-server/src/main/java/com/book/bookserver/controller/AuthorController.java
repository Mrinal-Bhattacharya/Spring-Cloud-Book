package com.book.bookserver.controller;

import com.book.bookserver.model.Author;
import com.book.bookserver.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/authors")
    public List<Author> getAll() {
        return this.authorService.getAll();
    }

    @GetMapping(value = "/authors/{id}")
    public Author getOne(@PathVariable Integer id) {
        return this.authorService.getOne(id);
    }
}
