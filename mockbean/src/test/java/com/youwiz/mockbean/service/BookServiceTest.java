package com.youwiz.mockbean.service;

import com.youwiz.mockbean.domain.Book;
import com.youwiz.mockbean.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

//import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void findAll_전체리스트() throws Exception {
        // given
        given(bookRepository.findAll())
                .willReturn(Arrays.asList(
                        new Book("YBM", 1000, 1L),
                        new Book("KBS", 1500, 1L)
                ));

        // when
        List<Book> books = bookService.findAll();

        // then
//        assertThat(books.size(), is(2));
//        assertThat(books.get(0).getName(), is("YBM"));
//        assertThat(books.get(1).getName(), is("KBS"));

    }
}