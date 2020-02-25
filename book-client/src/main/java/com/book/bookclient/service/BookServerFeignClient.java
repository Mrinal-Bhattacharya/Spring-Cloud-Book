package com.book.bookclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(value = "book-server",fallback = BookServerFeignClient.BookServerFallback.class)
public interface BookServerFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/books/")
    public String getBook();

    @Component
    public static class BookServerFallback implements BookServerFeignClient {
        @Override
        public String getBook() {
            return "None available!";
        }
    }
}
