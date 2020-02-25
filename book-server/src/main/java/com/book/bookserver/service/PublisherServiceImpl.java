package com.book.bookserver.service;

import com.book.bookserver.model.Publisher;
import com.book.bookserver.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public List<Publisher> getAll() {
        return this.publisherRepo.findAll();
    }

    @Override
    public Publisher getOne(final Integer id) {
        return this.publisherRepo.getOne(id);
    }
}
