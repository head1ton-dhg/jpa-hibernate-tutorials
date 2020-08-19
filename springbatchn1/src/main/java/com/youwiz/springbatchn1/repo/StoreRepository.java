package com.youwiz.springbatchn1.repo;

import com.youwiz.springbatchn1.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
