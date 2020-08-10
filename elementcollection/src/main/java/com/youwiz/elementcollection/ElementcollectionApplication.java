package com.youwiz.elementcollection;

import com.youwiz.elementcollection.model.Address;
import com.youwiz.elementcollection.model.User;
import com.youwiz.elementcollection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ElementcollectionApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ElementcollectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        Set<String> phoneNumbers = new HashSet<>();
        phoneNumbers.add("+91-999999999");
        phoneNumbers.add("+91-989898989");

        Set<Address> addresses = new HashSet<>();
        addresses.add(new Address("747", "Golf View Road", "Bangalore", "Karnataka", "Korea", "560008"));
        addresses.add(new Address("Plot No 44", "Electronic City", "Bangalore", "Karnataka", "Korea", "560001"));

        User user = new User("Head1ton", "head1ton@gmail.com", phoneNumbers, addresses);

        userRepository.save(user);
    }
}
