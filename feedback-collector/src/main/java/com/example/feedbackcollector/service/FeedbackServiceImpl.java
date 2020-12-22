package com.example.feedbackcollector.service;

import com.example.feedbackcollector.repository.FeedbackRepository;
import com.example.feedbackcollector.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    @Override
    public List<Feedback> getAllFeedback() {
        return repository.findAll();
    }

    @Override
    public Feedback getFeedback(String pageId) {
        return repository.findByPageId(pageId);
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return repository.save(feedback);
    }
}
