package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/")
public class LoginController {
    @Autowired
    private UUIDAuthenticationService uuidAuth;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(path = {"/login"})
    public @ResponseBody
    Optional<String> login(@RequestParam String username, @RequestParam String password) {
        Optional<String> os = uuidAuth.login(username, password);
        return Optional.of(os.isPresent() ? os.get() : "");
    }

    // GET /feedback/{id} -- # Returns a specific feedback
    @GetMapping(path = "/get")
    public @ResponseBody
    User getUser(@RequestParam int id) {
        return userServiceImpl.findUserById(id);
    }


    @RequestMapping(path = {"/post"})
    public @ResponseBody Optional<String> post(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userServiceImpl.saveUser(user);
        return Optional.of(user.getId().toString());
    }

    @DeleteMapping(path = {"/delete"})
    public @ResponseBody String delete(@RequestParam Integer id) {
        userServiceImpl.deleteUserById(id);
        return new StringBuilder().append("user with id").append(id).append(" deleted").toString();
    }


    @GetMapping(path = "/logout")
    public @ResponseBody
    void logout(@RequestParam String uuid) {
        uuidAuth.logout(uuid);
    }
}