package com.example.kafka.config.producer;

import com.example.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, User> jsonKafkaTemplate;



    public void sendMessage(String message){
      //  LOGGER.info("Message Sent : {}",message);
        kafkaTemplate.send("TestTopic",message);

    }
    public void sendJsonMessage(User user){
      //  LOGGER.info("Message Sent : {}",message);
        Message<User> userMessage= MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC,"TestTopicJson").build();
        jsonKafkaTemplate.send(userMessage);

    }
}
