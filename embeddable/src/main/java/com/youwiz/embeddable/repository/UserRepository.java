package com.youwiz.embeddable.repository;

import com.youwiz.embeddable.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByNameFirstName(String firstName);

    List<User> findByNameLastName(String lastName);

    List<User> findByAddressCountry(String country);
}
