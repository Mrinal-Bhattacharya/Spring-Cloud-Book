package com.book.bookserver.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "publishers")
public class Publisher {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "A name is required!")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "An address is required!")
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "publisher")
    private Set<Book> publishedBooks;

    /**
     * Default constructor, required for entity classes
     */
    public Publisher() {
    }

    /**
     * Constructor
     */
    public Publisher(String name, String address, Set<Book> publishedBooks) {
        this.setName(name);
        this.setAddress(address);
        this.setPublishedBooks(publishedBooks);
    }


    /**
     * Getters and setters
     */
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(Set<Book> publishedBooks) {
        Set<Book> newPubBooks = publishedBooks != null ? new HashSet<Book>(publishedBooks) : null;
        Set<Book> oldPubBooks = this.publishedBooks != null ? new HashSet<Book>(this.publishedBooks) : null;
        if (oldPubBooks != null) {
            for (Book b : oldPubBooks) {
                this.removePublishedBook(b);
            }
        }
        if (newPubBooks != null) {
            for (Book b : newPubBooks) {
                this.addPublishedBook(b);
            }
        }
        else {
            if (this.publishedBooks != null) {
                this.publishedBooks.clear();
            }
        }
    }

    public void addPublishedBook(Book publishedBook) {
        if (this.publishedBooks == null) {
            this.publishedBooks = new HashSet<Book>();
        }
        if (!this.publishedBooks.contains(publishedBook)) {
            this.publishedBooks.add(publishedBook);
            publishedBook.setPublisher(this);
        }
    }

    public void removePublishedBook(Book publishedBook) {
        if (this.publishedBooks != null && publishedBook != null && this.publishedBooks.contains(publishedBook)) {
            this.publishedBooks.remove(publishedBook);
            publishedBook.setPublisher(null);
        }
    }

    /**
     * Create a human readable serialization.
     */
    public String toString() {
        String result = "{ name: '" + this.name + "', address:'" + this.address + ", publishedBooks: [";
        if (this.publishedBooks != null) {
            int i = 0, n = this.publishedBooks.size();
            for (Book b : this.publishedBooks) {
                result += "'" + b.getTitle() + "'";
                if (i < n - 1) {
                    result += ", ";
                }
                i++;
            }
        }
        result += "]}";
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Publisher) {
            Publisher publisher = (Publisher) obj;
            return (this.id.equals(publisher.id));
        }
        else
            return false;
    }
}