package com.example.controller;

import com.example.model.Feedback;
import com.example.model.User;
import com.example.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
//TODO: CHANGE RETURN TO JSON PLS
    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public ModelAndView createNewFeedback(@Valid Feedback feedback, @Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("feedback");
        } else {
            feedbackService.saveFeedback(feedback, user);
            modelAndView.addObject("successMessage", "Feedback has been submitted successfully");
            modelAndView.addObject("feedback", new Feedback());
            modelAndView.setViewName("feedback");

        }
        return modelAndView;
    }
}
