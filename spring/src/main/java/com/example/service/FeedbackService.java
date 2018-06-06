package com.example.service;
import com.example.model.Feedback;
import com.example.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackService {
    Feedback findFeedbackByRating(int rating);
    void saveFeedback(Feedback feedback, User user);
}
