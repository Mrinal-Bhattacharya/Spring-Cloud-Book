package com.book.bookserver.model;


import javax.persistence.*;
import javax.transaction.RollbackException;
import javax.transaction.*;
import javax.validation.constraints.NotNull;
import java.awt.print.Book;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book_details")
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 10)
    @NotNull(message = "An ISBN value is required!")
    private String isbn;

    @Column(nullable = false)
    @NotNull(message = "Qty is required!")
    private Integer qty;

    @Column(nullable = false)
    @NotNull(message = "Price is required!")
    private Integer price;


    /**
     * Default constructor, required for entity classes
     */
    public BookDetails() {
    }

    /**
     * Constructor
     */
    public BookDetails(String isbn, Integer qty, Integer price) {
        this.isbn = isbn;
        this.qty = qty;
        this.price = price;

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

    public Integer getQty() {
        return qty;
    }

    public void setQty(final Integer qty) {
        this.qty = qty;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            BookDetails bookDetails = (BookDetails) obj;
            return (this.id.equals(bookDetails.id));
        }
        else
            return false;
    }
}