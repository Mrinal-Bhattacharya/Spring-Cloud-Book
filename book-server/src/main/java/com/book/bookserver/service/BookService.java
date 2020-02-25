package com.book.bookserver.service;

import com.book.bookserver.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book getOne(Integer id);
}
