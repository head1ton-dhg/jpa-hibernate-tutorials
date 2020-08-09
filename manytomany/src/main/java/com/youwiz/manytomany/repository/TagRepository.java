package com.youwiz.manytomany.repository;

import com.youwiz.manytomany.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
