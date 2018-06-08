package com.example.service;

import com.example.configuration.SecurityConfiguration;
import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.HashMap;

@Service("userAuthenticationService")
public final class UUIDAuthenticationService implements UserAuthenticationService {

    @Qualifier("userService")
    @Autowired
    private UserServiceImpl userServiceImpl;

    private HashMap<String, User> activeUsers = new HashMap<>();

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Optional<String> login(final String username, final String password) {
        final String uuid = UUID.randomUUID().toString();
        // Validate that the username & password is correct
        if (userServiceImpl.findUserByUsername(username) == null) {
            return Optional.of("there is no such user");
        }
        User u = userServiceImpl.findUserByUsername(username);
        //compares
        if (!encoder.matches(password, u.getPassword())) {
            return Optional.of("wrong pw");
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