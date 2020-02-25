package com.book.bookclient.dto;

import java.io.Serializable;

public class Book {

    private String bookResponse;
    private String bookDetails;
    public Book() {
    }
    public Book(final String bookResponse, final String bookDetails) {
        this.bookResponse = bookResponse;
        this.bookDetails = bookDetails;
    }

    public String getBookResponse() {
        return bookResponse;
    }

    public void setBookResponse(final String bookResponse) {
        this.bookResponse = bookResponse;
    }

    public String getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(final String bookDetails) {
        this.bookDetails = bookDetails;
    }
}
