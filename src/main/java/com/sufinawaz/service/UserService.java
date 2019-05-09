package com.sufinawaz.service;

import com.sufinawaz.model.User;
import com.sufinawaz.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    final
    private UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUser(final String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
