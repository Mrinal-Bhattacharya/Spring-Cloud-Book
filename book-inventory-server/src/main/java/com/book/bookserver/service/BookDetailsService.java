package com.book.bookserver.service;

import com.book.bookserver.model.BookDetails;

import java.util.List;

public interface BookDetailsService {
    List<BookDetails> getAll();

    BookDetails getOne(Integer id);
}
