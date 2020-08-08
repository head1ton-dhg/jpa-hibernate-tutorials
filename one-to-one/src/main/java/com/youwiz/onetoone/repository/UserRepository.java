package com.youwiz.onetoone.repository;

import com.youwiz.onetoone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
