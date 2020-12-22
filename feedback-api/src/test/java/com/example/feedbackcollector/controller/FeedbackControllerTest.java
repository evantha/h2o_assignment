package com.example.feedbackcollector.controller;

import com.example.feedbackcollector.model.Feedback;
import com.example.feedbackcollector.service.FeedbackService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@WebMvcTest(FeedbackController.class)
class FeedbackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FeedbackService feedbackService;

    private static final String URI = "/api/v1/feedback";

    @Test
    public void getAllFeedbackTest() throws Exception {

        List<Feedback> feedbacks = List.of(getFeedback(3, "test1", null));
        when(feedbackService.getAllFeedback()).thenReturn(feedbacks);
        MvcResult mvcResult = mockMvc.perform(get(URI)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

        List<Feedback> result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                new TypeReference<List<Feedback>>() {
                });
        assertEquals(1, result.size());
    }

    @Test
    public void getSingleFeedbackTest() throws Exception {

        String pageId = "testPage1";
        Feedback feedback = getFeedback(3, "test1", pageId);
        when(feedbackService.getFeedback(pageId)).thenReturn(feedback);
        MvcResult mvcResult = mockMvc.perform(get(URI + "/{id}", pageId)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

        Feedback result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),Feedback.class);
        assertEquals(pageId, result.getProductId());
    }


    private Feedback getFeedback(int rating, String comment, String pageId) {
        Feedback feedback = new Feedback();
        feedback.setUserId("u1");
        feedback.setStarCount(rating);
        feedback.setDescription(comment);
        feedback.setProductId(pageId);
        return feedback;
    }

}