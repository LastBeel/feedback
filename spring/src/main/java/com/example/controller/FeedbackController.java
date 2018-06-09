package com.example.controller;

import com.example.model.Feedback;
import com.example.model.User;
import com.example.service.FeedbackServiceImpl;
import com.example.service.UUIDAuthenticationService;
import com.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path = "/feedback")
public class FeedbackController {
    @Autowired
    private UUIDAuthenticationService uuidAuth;
    @Autowired
    private FeedbackServiceImpl feedbackServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;

    //  GET /feedback/ -- # Returns a list of feedbacks
    @GetMapping(path = "/getAll")
    public @ResponseBody
    Iterable<Feedback> getAllFeedback() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userServiceImpl.findUserByUsername(auth.getName());
        System.out.println(user.getUsername() + " yeeeeeeeeee");
        return feedbackServiceImpl.getAllFeedback();
    }

    // GET /feedback/{id} -- # Returns a specific feedback
    @GetMapping(path = "/get")
    public @ResponseBody
    Feedback getFeedback(@RequestParam Integer id) {
        return feedbackServiceImpl.findFeedbackById(id);
    }

    // POST /feedback/ -- # Creates a new feedback
    @PostMapping(path = "/post")
    public @ResponseBody
    String addNewFeedback(@RequestParam Integer rating,
                          @RequestParam String comment) {
        Feedback n = new Feedback();
        n.setRating(rating);
        n.setComment(comment);
        feedbackServiceImpl.saveFeedback(n);
        return "Saved";
    }

}

//java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());        n.setFeedbackDate(date);
//Date date = new Date();
//feedbackService.saveFeedback(n, u);
//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//TODO: current date and post including user info