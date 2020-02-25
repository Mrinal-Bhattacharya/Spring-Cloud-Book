package com.book.bookclient.service;

import com.book.bookclient.config.RibbonConfig;
import com.book.bookclient.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;

@Service
@RibbonClient(name = "book-server", configuration = RibbonConfig.class)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookServerRestService bookRestService;

    @Autowired
    private BookInventoryServerRestService bookInventoryServerRestService;


    @Autowired
    private LoadBalancerClient loadBalancer;

    public Book getBook() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + loadBalancer.choose("BOOK-SERVER").getUri());
        return new Book(bookRestService.getBooks(),bookInventoryServerRestService.getBooks());
    }
}
