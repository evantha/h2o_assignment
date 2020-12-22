package com.example.feedbackcollector.service;

import com.example.feedbackcollector.model.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAllFeedback();

    Feedback getFeedback(String pageId);

    Feedback saveFeedback(Feedback feedback);
}
