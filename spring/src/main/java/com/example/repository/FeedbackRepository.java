package com.example.repository;

import com.example.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("feedbackRepository")
public interface FeedbackRepository  extends JpaRepository<Feedback, Integer> {
    Feedback findByRating(int rating);
}
