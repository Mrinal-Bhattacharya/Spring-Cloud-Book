package com.book.bookserver.repository;

import com.book.bookserver.model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailsRepo extends JpaRepository<BookDetails, Integer> {
}
