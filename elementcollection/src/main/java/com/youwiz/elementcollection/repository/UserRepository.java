package com.youwiz.elementcollection.repository;

import com.youwiz.elementcollection.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
