package com.example.controller;

import com.example.model.Feedback;
import com.example.service.FeedbackService;
import com.example.service.UserService;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/")
public class LoginController {
    @Autowired
    private UUIDAuthenticationService uuidAuth;

    @GetMapping(path = "/login")
    public @ResponseBody
    String login(@RequestParam String username, @RequestParam String password) {
        Optional<String> os = uuidAuth.login(username, password);
        return (os.isPresent() ? os.get() : "");
    }

    @GetMapping(path = "/logout")
    public @ResponseBody
    void logout(@RequestParam String uuid) {
        uuidAuth.logout(uuid);
    }
}