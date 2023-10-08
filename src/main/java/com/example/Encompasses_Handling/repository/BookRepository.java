package com.example.Encompasses_Handling.repository;

import com.example.Encompasses_Handling.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
