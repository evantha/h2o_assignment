package com.example.feedbackcollector.service;

import com.example.feedbackcollector.repository.FeedbackRepository;
import com.example.feedbackcollector.model.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImpl.class);


    @Autowired
    private FeedbackRepository repository;

    @Override
    public List<Feedback> getAllFeedback() {
        return repository.findAll();
    }

    @Override
    public Feedback getFeedback(String productId) {
        return repository.findByProductId(productId);
    }

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<Feedback> saveFeedback(Feedback feedback) {
        LOGGER.info("saving feedback asynchronously for userId {}", feedback.getUserId());
        Feedback saved = repository.save(feedback);
        return CompletableFuture.completedFuture(saved);
    }
}
