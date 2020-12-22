package com.example.feedbackcollector.service;

import com.example.feedbackcollector.model.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FeedbackService {
    List<Feedback> getAllFeedback();

    Feedback getFeedback(String productId);

    CompletableFuture<Feedback> saveFeedback(Feedback feedback);
}
