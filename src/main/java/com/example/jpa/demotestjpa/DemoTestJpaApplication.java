package com.example.jpa.demotestjpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@SpringBootApplication
public class DemoTestJpaApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoTestJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = User.builder()
                .name("KIDO")
                .joinedAt(LocalDateTime.now())
                .build();

        log.info("new user: " + user1);
        final User save = userRepository.save(user1);

        log.info("Save User:" + save);

        final Optional<User> userInfos = userRepository.findById(save.getId());
        if (userInfos.isPresent()) {
            log.info("Get User: " + userInfos.get());
        }

    }
}
