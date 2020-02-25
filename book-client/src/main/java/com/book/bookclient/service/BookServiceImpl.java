package com.book.bookclient.service;

import com.book.bookclient.dto.Books;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookServerFeignClient bookServerFeignClient;

    @Autowired
    private BookInventoryServerFeignClient bookInventoryServerFeignClient;

    /*@Override
    public List<Book> getAll() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        getData();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>0");
        System.out.println(UriComponentsBuilder.fromUriString("//book-server/books").build().toUriString());
        String bookResponse = getAllBooks();
        String bookDetails = restTemplate.getForObject(UriComponentsBuilder.fromUriString("//book-inventory-server/bookdetails").build().toUriString(), String.class);
        List<Book> books=new ArrayList<>();
        books.add(new Book(bookResponse,bookDetails));
        return books;
    }*/

    @HystrixCommand(fallbackMethod = "getBackupBook")
    @Override
    public Books getAllBooks() {
        return new Books(this.bookServerFeignClient.getBook(),this.bookInventoryServerFeignClient.getBook());
    }

    /*String getBackupBook(){
        return "No Book availableeeeeeee";
    }

    public void getData(){
        System.out.println(bookServerFeignClient.getBook());
    }*/
}
