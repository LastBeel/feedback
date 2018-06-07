package com.example.service;

import com.example.model.Feedback;
import com.example.model.User;
import com.example.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

    @Qualifier("feedbackRepository")
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Feedback findFeedbackByRating(int rating) {
        return feedbackRepository.findByRating(rating);
    }

    @Override
    public Iterable<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
}


/*    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;
*/