package com.book.bookclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class BookInventoryServerRestService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getBackupBook")
    public String getBooks() {
        return restTemplate.getForObject("//BOOK-INVENTORY-SERVER/books", String.class);
    }

    public String getBackupBook(){
        return "No Book availableeeeeeee";
    }
}
