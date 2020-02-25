package com.book.bookserver.service;

import com.book.bookserver.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    Author getOne(Integer id);
}
