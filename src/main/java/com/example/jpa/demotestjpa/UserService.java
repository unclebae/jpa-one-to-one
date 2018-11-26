package com.example.jpa.demotestjpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Optional<User> getUser(Long userId) {
        final Optional<User> userInfos = userRepository.findById(userId);
        if (userInfos.isPresent()) {
            log.info("Get User: " + userInfos.get());
            log.info("Get Address of 0: " + userInfos.get().getAddress().get(0));
        }

        return userInfos;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
