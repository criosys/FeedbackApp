package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.*;
import java.text.SimpleDateFormat;


/**
 * Created by n0148661 on 10/28/16.
 */
@Service
@EnableBinding(FeedbackStream.class)
public class EventTrigger {

    @Autowired
    FeedbackStream feedbackSource;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestTemplateBuilder builder;

    @StreamListener(FeedbackStream.IN)
    private void readStream(FeedbackItem feedback){
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm MM/dd/yy");
        System.out.println("--NEW MESSAGE--");
        System.out.println("Description: " + feedback.getDescription());
        System.out.println("Time: " + timeFormat.format(feedback.getTime()));

        String formattedMessage = "At "+
                timeFormat.format(feedback.getTime())+
                ", somebody felt "+
                feedback.getDescription();

        try {
            post(restTemplate, formattedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

        Authenticator.setDefault(new com.example.ProxyAuthenticator());



        Proxy proxy= new Proxy(Proxy.Type.HTTP, new InetSocketAddress("www-proxy.lmig.com", 8080));
        requestFactory.setProxy(proxy);

        return new RestTemplate(requestFactory);

    }

    public void post(RestTemplate restTemplate, String msg) throws Exception {
            String slackURL = "https://hooks.slack.com/services/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";
            HttpEntity<SlackMessage> request = new HttpEntity<>(new SlackMessage(msg));
            URI foo = restTemplate.postForLocation(slackURL, request);
    }


}
