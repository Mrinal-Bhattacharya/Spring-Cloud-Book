package com.book.bookserver.service;

import com.book.bookserver.model.Author;
import com.book.bookserver.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public List<Author> getAll() {
        return this.authorRepo.findAll();
    }

    @Override
    public Author getOne(final Integer id) {
        return this.authorRepo.getOne(id);
    }
}
