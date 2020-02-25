package com.book.bookserver.config;

import com.book.bookserver.model.Author;
import com.book.bookserver.model.Book;
import com.book.bookserver.model.Publisher;
import com.book.bookserver.repository.AuthorRepo;
import com.book.bookserver.repository.BookRepo;
import com.book.bookserver.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Profile("cloud")
@Configuration
public class BookServerApplicationRunner implements ApplicationRunner {
    @Autowired
    private PublisherRepo publisherRepo;
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private BookRepo bookRepo;


    @Override
    public void run(final ApplicationArguments args) throws Exception {
        bookRepo.deleteAll();
        publisherRepo.deleteAll();
        authorRepo.deleteAll();
        Publisher publisher = new Publisher();
        publisher.setName("Apress");
        publisher.setAddress("Delhi");
        publisher = publisherRepo.save(publisher);
        Author author = new Author();
        author.setName("Jimi");
        author = authorRepo.save(author);
        Book book = new Book();
        book.addAuthor(author);
        book.setPublisher(publisher);
        book.setIsbn("isbn-12345");
        book.setTitle("Spring cloud");
        book.setYear(2020);
        book = bookRepo.save(book);
        System.out.println(publisherRepo.findById(publisher.getId()));
        System.out.println(author);
        System.out.println(book);
    }
}
