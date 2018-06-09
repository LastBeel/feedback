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
    private int nextId = 0;
    @Autowired
    private UUIDAuthenticationService uuidAuth;
    @Autowired
    private UserService userService;

    @GetMapping(path = {"/", "/login"})
    public @ResponseBody
    Optional<String> login(@RequestParam String username, @RequestParam String password) {
        Optional<String> os = uuidAuth.login(username, password);
        return Optional.of(os.isPresent() ? os.get() : "");
    }

    @RequestMapping(path = {"/post"})
    public String post(@RequestParam String username, @RequestParam String password) {
        //only iterated the first time
        //there is no user with Id nextId, so it makes a loop until found
        StringBuilder sb = new StringBuilder();
        while (userService.findUserById(sb.append(nextId).toString()) != null) {
            sb.setLength(0);
            nextId++;
        }
        User user = new User("" + nextId, username, password);
        nextId++;

        userService.saveUser(user);
        return user.getUsername();
    }

    @DeleteMapping(path = {"/delete"})
    public String delete(@RequestParam String id) {
        userService.deleteUserById(id);
        return new StringBuilder().append("user with id").append(id).append(" deleted").toString();
    }


    @GetMapping(path = "/logout")
    public @ResponseBody
    void logout(@RequestParam String uuid) {
        uuidAuth.logout(uuid);
    }
}