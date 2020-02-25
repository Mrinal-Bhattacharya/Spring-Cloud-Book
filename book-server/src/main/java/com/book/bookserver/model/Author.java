package com.book.bookserver.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "A name is required!")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    private Set<Book> authoredBooks;

    /**
     * Default constructor, required for entity classes
     */
    public Author() {
    }

    /**
     * Constructor
     */
    public Author(Integer personId, String name, Set<Book> authoredBooks) {
        this.setPersonId(personId);
        this.setName(name);
        this.setAuthoredBooks(authoredBooks);
    }

    /**
     * Getters and setters
     */
    public Integer getPersonId() {
        return id;
    }

    public void setPersonId(Integer personId) {
        this.id = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getAuthoredBooks() {
        return authoredBooks;
    }

    public void setAuthoredBooks(Set<Book> authoredBooks) {
        Set<Book> oldAuthBooks = this.authoredBooks != null ? new HashSet<Book>(this.authoredBooks) : null;
        Set<Book> newAuthBooks = authoredBooks != null ? new HashSet<Book>(authoredBooks) : null;
        if (oldAuthBooks != null) {
            for (Book b : oldAuthBooks) {
                this.removeAuthoredBook(b);
            }
        }
        // add this book to the authoredBooks of the new authors of this book
        if (newAuthBooks != null) {
            for (Book b : newAuthBooks) {
                this.addAuthoredBook(b);
            }
        }
        else {
            if (this.authoredBooks != null) {
                this.authoredBooks.clear();
            }
        }
    }

    public void addAuthoredBook(Book authoredBook) {
        if (this.authoredBooks == null) {
            this.authoredBooks = new HashSet<Book>();
        }
        if (!this.authoredBooks.contains(authoredBook)) {
            this.authoredBooks.add(authoredBook);
            authoredBook.addAuthor(this);
        }
    }

    public void removeAuthoredBook(Book authoredBook) {
        if (this.authoredBooks != null && authoredBook != null && this.authoredBooks.contains(authoredBook)) {
            this.authoredBooks.remove(authoredBook);
            authoredBook.removeAuthor(this);
        }
    }

    /**
     * Create a human readable serialization.
     */
    public String toString() {
        String result = "{ personId: " + this.id + ", name:'" + this.name;
        result += ", authoredBooks: [";
        if (this.authoredBooks != null) {
            int i = 0, n = this.authoredBooks.size();
            for (Book b : this.authoredBooks) {
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
        if (obj instanceof Author) {
            Author author = (Author) obj;
            return (this.id.equals(author.id));
        }
        else
            return false;
    }
}