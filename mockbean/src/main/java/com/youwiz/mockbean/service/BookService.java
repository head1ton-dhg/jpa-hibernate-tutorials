package com.youwiz.mockbean.service;

import com.youwiz.mockbean.domain.Book;
import com.youwiz.mockbean.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
}
