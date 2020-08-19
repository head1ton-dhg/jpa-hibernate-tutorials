package com.youwiz.mockbean.repository;

import com.youwiz.mockbean.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
