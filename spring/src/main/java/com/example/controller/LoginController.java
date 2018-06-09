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
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(path = "/")
public class LoginController {
    @Autowired
    private UUIDAuthenticationService uuidAuth;
    @Autowired
    private FeedbackService feedbackService;


    // GET /feedback/{id} -- # Returns a specific feedback
    @GetMapping(path = "/get")
    public @ResponseBody
    Feedback getFeedback(@RequestParam int id) {
        return feedbackService.findFeedbackById(id);
    }

    // POST /feedback/ -- # Creates a new feedback
    @PostMapping(path = "/post")
    public @ResponseBody
    String addNewFeedback(@RequestParam int rating,
                          @RequestParam String comment) {
        Feedback n = new Feedback();
        n.setRating(rating);
        n.setComment(comment);
        feedbackService.saveFeedback(n);
        return "Saved";
    }

    @GetMapping(path = "/login")
    public @ResponseBody
    Optional<String> login(@RequestParam String username, @RequestParam String password) {
        Optional<String> os = uuidAuth.login(username, password);
       // return (os.isPresent() ? os.get() : "");
        return os;
    }


    //  GET /feedback/ -- # Returns a list of feedbacks
    @GetMapping(path = "/getAll")
    public @ResponseBody
    Iterable<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }



    @GetMapping(path = "/logout")
    public @ResponseBody
    void logout(@RequestParam String uuid) {
        uuidAuth.logout(uuid);
    }
}