package com.youwiz.onetoone.repository;

import com.youwiz.onetoone.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
