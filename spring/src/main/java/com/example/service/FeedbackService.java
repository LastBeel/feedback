package com.example.service;

import com.example.model.Feedback;
import com.example.model.User;
import org.springframework.stereotype.Service;


@Service
public interface FeedbackService {

    Feedback findFeedbackById(int id);

    Feedback deleteFeedbackById(int id);

    void saveFeedback(Feedback feedback);

    Iterable<Feedback> getAllFeedback();

}
