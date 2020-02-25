package com.book.bookserver.service;

import com.book.bookserver.model.Book;
import com.book.bookserver.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book getOne(final Integer id) {
        return this.bookRepo.getOne(id);
    }
}
