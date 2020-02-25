package com.book.bookserver.service;

import com.book.bookserver.model.Publisher;

import java.util.List;

public interface PublisherService {
    List<Publisher> getAll();

    Publisher getOne(Integer id);
}
