package com.book.bookclient.controller;

import brave.Tracer;
import com.book.bookclient.dto.Books;
import com.book.bookclient.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @Autowired
    private Tracer tracer;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping(value = "/allbooks")
    public Books getAll() {
        LOG.info("entering getAll");
        //ServiceInstance serviceInstance=loadBalancer.choose("book-server");
        //System.out.println("$$$$$$$$$$$$$$$$$"+serviceInstance.getUri()+" Host "+serviceInstance.getHost());
        //String baseUrl=serviceInstance.getUri().toString();
        //baseUrl=baseUrl+"/books/";
        Books books= bookService.getAllBooks();
        LOG.info("exiting getAll"+books);
        return books;
    }

    /*@GetMapping(value = "/books")
    public String get() {
        Span newSpan = tracer.nextSpan().name("newSpan").start();
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
            Thread.sleep(1000L);
            LOG.info("I'm in the new span doing some cool work that needs its own span");
        } finally {
            newSpan.finish();
        }
        ServiceInstance serviceInstance=loadBalancer.choose("book-server");
        System.out.println("$$$$$$$$$$$$$$$$$"+serviceInstance.getUri()+" Host "+serviceInstance.getHost());
        String baseUrl=serviceInstance.getUri().toString();
        baseUrl=baseUrl+"/books/";
        return bookService.getAllBooks();
    }*/
}
