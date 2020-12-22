package com.example.feedbackcollector.controller;

import com.example.feedbackcollector.model.Feedback;
import com.example.feedbackcollector.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@Validated
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> getAllFeedback() {
        System.out.println("getAllFeedback");
        return feedbackService.getAllFeedback();
    }

    @GetMapping(path = "{pageId}")
    public Feedback getFeedback(@PathVariable("pageId") String pageId) {
        System.out.println("getFeedback "+ pageId);
        return feedbackService.getFeedback(pageId);
    }

    @PostMapping
    public Feedback saveFeedback(@Valid @RequestBody Feedback feedback) throws ExecutionException, InterruptedException {
        System.out.println("saveFeedback " + feedback);
        return feedbackService.saveFeedback(feedback).get();
    }
}
