package com.example.controller;

import com.example.model.Feedback;
import com.example.model.User;
import com.example.service.FeedbackService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UserService userService;
    //TODO: CHANGE RETURN TO JSON PLS

    @GetMapping(path = "/addFeedback")
    public @ResponseBody
    String addNewFeedback(@RequestParam int rating,
                          @RequestParam String comment) {
        Feedback n = new Feedback();
        n.setRating(rating);
        n.setComment(comment);
        feedbackService.saveFeedback(n);
        return "Saved";
    }
    //java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());        n.setFeedbackDate(date);
    //Date date = new Date();
    //feedbackService.saveFeedback(n, u);
    //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //TODO: current date and savefeedback including user info


    @GetMapping(path = "/getAllFeedback")
    public @ResponseBody
    Iterable<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }




}