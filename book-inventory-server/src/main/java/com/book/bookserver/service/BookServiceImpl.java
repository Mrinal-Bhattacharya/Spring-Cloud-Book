package com.book.bookserver.service;

import com.book.bookserver.model.BookDetails;
import com.book.bookserver.repository.BookDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookDetailsService {
    @Autowired
    private BookDetailsRepo bookRepo;

    @Override
    public List<BookDetails> getAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public BookDetails getOne(final Integer id) {
        return this.bookRepo.getOne(id);
    }
}
