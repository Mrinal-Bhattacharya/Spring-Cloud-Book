package com.book.bookclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "book-inventory-server",fallback =
        BookInventoryServerFeignClient.BookInventoryServerFallback.class)
public interface BookInventoryServerFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/books/")
    public String getBook();

    @Component
    public static class BookInventoryServerFallback implements BookInventoryServerFeignClient {
        @Override
        public String getBook() {
            return "None available!";
        }
    }
}
