package com.book.bookclient.controller;

import com.book.bookclient.service.BookService;
import com.book.bookclient.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookclient.dto.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping(value = "/allbooks")
    public List<Book> getAll() {
        //ServiceInstance serviceInstance=loadBalancer.choose("book-server");
        //System.out.println("$$$$$$$$$$$$$$$$$"+serviceInstance.getUri()+" Host "+serviceInstance.getHost());
        //String baseUrl=serviceInstance.getUri().toString();
        //baseUrl=baseUrl+"/books/";
        List<Book> books=new ArrayList<>();
        books.add(bookServiceImpl.getBook());
        return books;
    }
}
