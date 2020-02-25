package com.book.bookclient.service;

import com.book.bookclient.dto.Books;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public interface BookService {

    @HystrixCommand(fallbackMethod = "getBackupBook")
    Books getAllBooks();
}
