package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

import static java.util.Optional.ofNullable;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    BCryptPasswordEncoder encoder;
    //  Map<String, User> users = new HashMap<>();
    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> deleteUserById(String id) {
        return Optional.empty();
    }

    @Override
    public void saveUser(final User user) {
        //return users.put(user.getId(), user);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
