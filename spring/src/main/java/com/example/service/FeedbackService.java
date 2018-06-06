package com.example.service;
import com.example.model.Feedback;

public interface FeedbackService {
    Feedback findFeedbackByRating(int rating);
    void saveFeedback(Feedback feedback);
}
