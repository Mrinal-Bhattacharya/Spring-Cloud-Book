package com.book.bookserver.config;

import com.book.bookserver.model.BookDetails;
import com.book.bookserver.repository.BookDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Profile("cloud")
@Configuration
public class BookInventoryApplicationRunner implements ApplicationRunner {
    @Autowired
    private BookDetailsRepo bookRepo;


    @Override
    public void run(final ApplicationArguments args) throws Exception {
        bookRepo.deleteAll();
        BookDetails book = new BookDetails();
        book.setIsbn("isbn-12345");
        book.setPrice(1000);
        book.setQty(100);
        book = bookRepo.save(book);
    }
}
