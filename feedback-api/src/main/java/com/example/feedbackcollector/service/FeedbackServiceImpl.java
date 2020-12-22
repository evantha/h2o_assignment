package com.example.feedbackcollector.service;

import com.example.feedbackcollector.repository.FeedbackRepository;
import com.example.feedbackcollector.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
    @Async("asyncExecutor")
    public CompletableFuture<Feedback> saveFeedback(Feedback feedback) {
        Feedback saved = repository.save(feedback);
        return CompletableFuture.completedFuture(saved);
    }
}
