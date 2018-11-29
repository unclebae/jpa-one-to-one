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
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DemoTestJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = User.builder()
                .name("KIDO")
                .joinedAt(LocalDateTime.now())
                .build();

        user1.addAddress(Address.builder()
                .name("OFFICE")
                .sido("서울시")
                .doro("을지로큰길")
                .detail("큰길빌딩 101")
                .build());

        user1.addAddress(Address.builder()
                .name("HOME")
                .sido("서울시")
                .doro("을지로큰길")
                .detail("큰 아파트 101동 105호")
                .build());

        user1.addAddress(Address.builder()
                .name("FAVORITE")
                .sido("서울시")
                .doro("을지로작은길")
                .detail("직은길빌딩 101")
                .build());

        user1.setUserProfile(UserProfile.builder()
                .age(30)
                .weight(70)
                .tall(177)
                .createdAt(LocalDateTime.now())
                .build());

        user1.setUserCurrentJob(UserCurrentJob.builder()
                .companyName("SKT")
                .jobName("Programmer")
                .title("Developer")
                .joinedAt(LocalDateTime.now())
                .build()
                );


        log.info("new user: " + user1);
        final User save = userService.save(user1);

        log.info("Save User:" + save);

        final Optional<User> userInfos = userService.getUser(save.getId());
        if (userInfos.isPresent()) {
            log.info("Get User: " + userInfos.get());
        }
    }
}
