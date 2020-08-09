package com.youwiz.manytomany;

import com.youwiz.manytomany.model.Post;
import com.youwiz.manytomany.model.Tag;
import com.youwiz.manytomany.repository.PostRepository;
import com.youwiz.manytomany.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManytomanyApplication implements CommandLineRunner {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManytomanyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        postRepository.deleteAllInBatch();
        tagRepository.deleteAllInBatch();

        Post post = new Post("Hibernate Many to Many Example with Spring Boot.",
                "Learn how to map a many to many relationship using hibernate",
                "Entire Post content with Sample code");

        Tag tag1 = new Tag("Spring Boot");
        Tag tag2 = new Tag("Hibernate");

        post.getTags().add(tag1);
        post.getTags().add(tag2);

        tag1.getPosts().add(post);
        tag1.getPosts().add(post);

        postRepository.save(post);
    }
}
