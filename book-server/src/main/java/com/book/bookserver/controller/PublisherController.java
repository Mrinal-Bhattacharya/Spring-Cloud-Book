package com.book.bookserver.controller;

import com.book.bookserver.model.Publisher;
import com.book.bookserver.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping(value = "/publishers")
    public List<Publisher> getAll() {
        return this.publisherService.getAll();
    }

    @GetMapping(value = "/publishers/{id}")
    public Publisher getOne(@PathVariable Integer id) {
        return this.publisherService.getOne(id);
    }

}
