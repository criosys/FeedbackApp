package com.example;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by n0148661 on 10/28/16.
 */
public interface FeedbackStream {

    String IN = "feedbackStreamInput";
    String OUT = "feedbackStreamOut";


    @Output(OUT)
    MessageChannel output();

    @Input(IN)
    SubscribableChannel input();

}
