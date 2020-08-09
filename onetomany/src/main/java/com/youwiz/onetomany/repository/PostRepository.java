package com.youwiz.onetomany.repository;

import com.youwiz.onetomany.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
