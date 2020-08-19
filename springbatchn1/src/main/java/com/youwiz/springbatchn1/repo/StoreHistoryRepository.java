package com.youwiz.springbatchn1.repo;

import com.youwiz.springbatchn1.domain.StoreHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreHistoryRepository extends JpaRepository<StoreHistory, Long> {
}
