package com.example.repository;

import com.example.model.Feedback;

public interface FeedbackRepository {
    Feedback findByRating(int rating);
}
