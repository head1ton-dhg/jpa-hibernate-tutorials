package com.youwiz.mockbean.service;

import com.youwiz.mockbean.domain.Book;
import com.youwiz.mockbean.domain.Manager;
import com.youwiz.mockbean.repository.BookRepository;
import com.youwiz.mockbean.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private BookRepository bookRepository;

//    public ManagerService(ManagerRepository managerRepository, BookRepository bookRepository) {
//        this.managerRepository = managerRepository;
//        this.bookRepository = bookRepository;
//    }

    @Transactional(readOnly = true)
    public List<Book> findAllHasBook(Long managerId) {
        Manager manager = Optional.ofNullable(managerRepository.findOne(managerId))
                .orElseThrow(() -> new RuntimeException("존재하지 않는 Manager Id 입니다."));

        return bookRepository.findAllByManagerId(manager.getId())
                .collect(Collectors.toList());
    }
}
