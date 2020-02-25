package com.book.bookclient.service;

import com.book.bookclient.dto.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServerRestService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getBackupBook")
    public String getBooks() {
        return restTemplate.getForObject("//BOOK-SERVER/books", String.class);
    }

    public String getBackupBook(){
        return "No Book availableeeeeeee";
    }
}
