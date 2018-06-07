package com.example.controller;

import com.example.model.Feedback;
import com.example.service.FeedbackService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;


    //  GET /feedback/ -- # Returns a list of feedbacks
    @GetMapping(path = "/getAll")
    public @ResponseBody
    Iterable<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

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

}

//java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());        n.setFeedbackDate(date);
//Date date = new Date();
//feedbackService.saveFeedback(n, u);
//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//TODO: current date and post including user info