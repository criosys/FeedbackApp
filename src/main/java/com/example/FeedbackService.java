package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by n0148661 on 11/9/16.
 */

@RestController
public class FeedbackService {

    @Autowired
    FeedbackStream feedbackSource;

    @RequestMapping(value="/ping", method=RequestMethod.GET)
    public String foobar(){
        return "hello";
    }


    @RequestMapping(value="/post", method = RequestMethod.POST)
    public ResponseEntity<FeedbackItem> postTest(@RequestBody FeedbackItem feedback) {
        sendMessage(feedback);
        return new ResponseEntity<FeedbackItem> (feedback, HttpStatus.CREATED);
    }

    private void sendMessage(FeedbackItem feedback) {
        System.out.println("Emitting event");
        // set the time to right now
        Date now = new Date();
        feedback.setTime(now);

        this.feedbackSource.output().send(MessageBuilder.withPayload(feedback).build());

    }
}
