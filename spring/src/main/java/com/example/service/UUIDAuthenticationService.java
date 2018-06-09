package com.example.service;

import com.example.configuration.SecurityConfiguration;
import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.NonNull;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import java.util.*;

@Service("userAuthenticationService")
public final class UUIDAuthenticationService implements UserAuthenticationService {

    @Qualifier("userService")
    @Autowired
    private UserServiceImpl userServiceImpl;

    private HashMap<String, User> activeUsers = new HashMap<>();
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public Optional<String> login(final String username, final String password) {
        final String uuid = UUID.randomUUID().toString();
        // Validate that the username & password is correct
        if (userServiceImpl.findUserByUsername(username) == null) {
            return Optional.of("No such user");
        }
        User u = userServiceImpl.findUserByUsername(username);
        //compares
        if (!encoder.matches(password, u.getPassword())) {
            return Optional.of("bad pw");
        }
        // Get the user id from username
        activeUsers.put(uuid, u);
      //  ModelAndView modelAndView = new ModelAndView();
        // old login ???modelAndView.setViewName("login");
        return Optional.of(uuid);
    }

    @Override
    public User findUserByToken(final String uuid) {
        return activeUsers.get(uuid);
    }

    @Override
    public String findTokenByUser(final User user) {
  /*      for (HashMap.Entry<String, User> u : activeUsers.entrySet()) {
            if (u.equals(user)) {
                return u.getKey();
            }
        }*/
        return null;
    }

    @Override
    public void logout(final String uuid) {
        activeUsers.remove(uuid);
    }

}