package com.book.bookserver.model;


import javax.persistence.*;
import javax.transaction.RollbackException;
import javax.transaction.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 10)
    @NotNull(message = "An ISBN value is required!")
    private String isbn;

    @Column(nullable = false)
    @NotNull(message = "A title is required!")
    private String title;

    @Column(nullable = false)
    @NotNull(message = "A year is required!")
    private Integer year;

    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "books_authors", joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Author> authors;

    /**
     * Default constructor, required for entity classes
     */
    public Book() {
    }

    /**
     * Constructor
     */
    public Book(String isbn, String title, Integer year, Publisher publisher, Set<Author> authors) {
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setYear(year);
        this.setPublisher(publisher);
        this.setAuthors(authors);
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Getters and setters
     */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        Set<Author> oldAUthors = this.authors != null ? new HashSet<Author>(this.authors) : null;
        // remove old authors
        if (oldAUthors != null) {
            for (Author a : oldAUthors) {
                this.removeAuthor(a);
            }
        }
        // add new authors
        if (authors != null) {
            for (Author a : authors) {
                this.addAuthor(a);
            }
        }
        else {
            if (this.authors != null) {
                this.authors.clear();
            }
        }
    }

    public void addAuthor(Author author) {
        if (this.authors == null) {
            this.authors = new HashSet<Author>();
        }
        if (!this.authors.contains(author)) {
            this.authors.add(author);
            author.addAuthoredBook(this);
        }
    }

    public void removeAuthor(Author author) {
        if (this.authors != null && author != null && this.authors.contains(author)) {
            this.authors.remove(author);
            author.removeAuthoredBook(this);
        }
    }

    /**
     * Return the serialized author names used in the JSF views.
     *
     * @return serialized author names for this book.
     */
    public String getAuthorNames() {
        String result = "";
        int i = 0, n = 0;
        if (this.authors != null) {
            n = this.authors.size();
            for (Author author : this.authors) {
                result += author.getName();
                if (i < n - 1) {
                    result += ", ";
                }
                i++;
            }
        }
        return result;
    }

    /**
     * Create a human readable serialisation.
     */
    public String toString() {
        String result = "{ isbn: '" + this.isbn + "', title:'" + this.title + "', year: " + this.year + ", publisher: " + (this.publisher != null ? this.publisher.getName() : "") + ", authors: [";
        if (this.authors != null) {
            int i = 0, n = this.authors.size();
            for (Author a : this.authors) {
                result += "'" + a.getName() + "'";
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
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return (this.id.equals(book.id));
        }
        else
            return false;
    }
}