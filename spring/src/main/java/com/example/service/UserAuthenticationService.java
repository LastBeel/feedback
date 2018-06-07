package com.example.service;

import com.example.model.User;

import java.util.Optional;

public interface UserAuthenticationService {

    /**
     * Logs in with the given {@code username} and {@code password}.
     *
     * @param username
     * @param password
     * @return an {@link Optional} of a user when login succeeds
     */
    Optional<String> login(String username, String password);

    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     * @return
     */
    User findByToken(String token);

    /**
     * Logs out the given input {@code uuid}.
     *
     * @param uuid the uuid to remove
     */
    void logout(String uuid);
}