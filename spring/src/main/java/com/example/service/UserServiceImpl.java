package com.example.service;

import java.util.*;

import com.example.model.Role;
import com.example.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

import static java.util.Optional.ofNullable;

@Service("userService")
public class UserServiceImpl implements UserService {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    //  Map<String, User> users = new HashMap<>();
    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;
    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> deleteUserById(int id) {
        return Optional.empty();
    }

    @Override
    public void saveUser(final User user) {
        //return users.put(user.getId(), user);
        user.setPassword(encoder.encode(user.getPassword()));
        //  Role userRole = roleRepository.findByRole("ADMIN");
        //  user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        //  some temp but working solution
        user.setAdmin(true);

        userRepository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
