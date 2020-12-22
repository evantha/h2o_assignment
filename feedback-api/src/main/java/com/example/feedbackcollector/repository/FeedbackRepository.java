package com.example.feedbackcollector.repository;

import com.example.feedbackcollector.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {

    Feedback findByPageId(String pageId);

}
