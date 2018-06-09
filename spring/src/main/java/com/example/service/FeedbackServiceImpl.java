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
    public Feedback findFeedbackById(int id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public Feedback deleteFeedbackById(int id) {
        return feedbackRepository.deleteById(id);
    }

    @Override
    public Iterable<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public Iterable<Feedback> getAllFedback() {
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