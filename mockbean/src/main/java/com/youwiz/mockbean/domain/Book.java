package com.youwiz.mockbean.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private long price;
    private Long managerId;

    public Book(String name, long price, Long managerId) {
        this.name = name;
        this.price = price;
        this.managerId = managerId;
    }
}
