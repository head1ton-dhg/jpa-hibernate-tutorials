package com.youwiz.mockbean.repository;

import com.youwiz.mockbean.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<Book, Long> {

    Stream<Book> findAllByManagerId(Long managerId);
}
