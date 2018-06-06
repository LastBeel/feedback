package com.example.repository;

import com.example.model.Feedback;
import org.springframework.stereotype.Repository;

@Repository("feedbackRepository")

public interface FeedbackRepository {
    Feedback findByRating(int rating);
}
