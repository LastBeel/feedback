package com.example.service;

import com.example.model.User;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;
import java.util.HashMap;


public final class UUIDAuthenticationService implements UserAuthenticationService {
    @NonNull
    UserService userService = new UserServiceImpl();
    @Autowired
    private HashMap<String, User> activeUsers;

    @Override
    public Optional<String> login(final String username, final String password) {
        final String uuid = UUID.randomUUID().toString();
        // Validate that the username & password is correct
        User u = userService.findUserByUsername(username);
        if (!u.getPassword().equals(password)) {
            return Optional.empty();
        }
        // Get the user id from username
        activeUsers.put(uuid, u);
        return Optional.of(uuid);
    }

    @Override
    public User findByToken(final String uuid) {
        return activeUsers.get(uuid);
    }

    @Override
    public void logout(final String uuid) {
        activeUsers.remove(uuid);
    }
}