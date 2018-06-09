package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    User findUserById(int id);

    User findUserByUsername(String username);

    Optional<User> deleteUserById(int id);

    void saveUser(User user);

    Iterable<User> getAllUsers();

}
