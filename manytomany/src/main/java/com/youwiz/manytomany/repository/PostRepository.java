package com.youwiz.manytomany.repository;

import com.youwiz.manytomany.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
