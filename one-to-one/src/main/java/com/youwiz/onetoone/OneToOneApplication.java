package com.youwiz.onetoone;

import com.youwiz.onetoone.model.Gender;
import com.youwiz.onetoone.model.User;
import com.youwiz.onetoone.model.UserProfile;
import com.youwiz.onetoone.repository.UserProfileRepository;
import com.youwiz.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public static void main(String[] args) {
        SpringApplication.run(OneToOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userProfileRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();

        User user = new User("Rajeev", "Singh", "rajeev@gmail.com", "@@BestSecurity001");

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);

        UserProfile userProfile = new UserProfile("+82-1092090179", Gender.MALE, dateOfBirth.getTime(),
                "747", "2nd Cross", "Golf View Road, Kodihalli", "Bangalore",
                "Karnataka", "Korea", "560008");

        user.setUserProfile(userProfile);

        userProfile.setUser(user);

        userRepository.save(user);
    }
}
