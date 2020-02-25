package com.book.bookserver.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class BookResponse {
    private Integer id;
    private String isbn;
    private String title;
    private Integer year;

    public BookResponse(final Integer id, final String isbn, final String title, final Integer year) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }
}
