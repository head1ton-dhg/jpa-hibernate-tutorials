package com.youwiz.springbatchn1.service;

import com.youwiz.springbatchn1.domain.Employee;
import com.youwiz.springbatchn1.domain.Product;
import com.youwiz.springbatchn1.domain.Store;
import com.youwiz.springbatchn1.repo.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public long find() {
        List<Store> stores = storeRepository.findAll();
        long productSum = stores.stream()
                .map(Store::getProducts)
                .flatMap(Collection::stream)
                .mapToLong(Product::getPrice)
                .sum();

        stores.stream()
                .map(Store::getEmployees)
                .flatMap(Collection::stream)
                .map(Employee::getName)
                .collect(Collectors.toList());

        return productSum;
    }
}
