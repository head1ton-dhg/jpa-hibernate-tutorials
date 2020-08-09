package com.youwiz.embeddable;

import com.youwiz.embeddable.model.Address;
import com.youwiz.embeddable.model.Name;
import com.youwiz.embeddable.model.User;
import com.youwiz.embeddable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmbeddableApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmbeddableApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAllInBatch();

        Name name = new Name("head", "1", "ton");
        Address address = new Address("747", "Golf View Road", "Bangalore", "Karnataka", "India", "56008");
        User user = new User(name, "head1ton@gmail.com", address);

        userRepository.save(user);
    }
}
