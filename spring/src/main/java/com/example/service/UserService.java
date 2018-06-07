package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findUserById(int id);

    User findUserByEmail(String email);

    void deleteUserById(int id);

    void saveUser(User user);

    Iterable<User> getAllUsers();



}
