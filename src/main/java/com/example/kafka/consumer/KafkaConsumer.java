package com.example.kafka.consumer;

import com.example.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static Logger logger= LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "TestTopic",groupId = "myGroup")
    public void consume(String message){
        logger.info("Message received - {}",message);
    }
    @KafkaListener(topics = "TestTopicJson",groupId = "myGroup")
    public void consume(User message){
        logger.info("Message received - {}",message.toString());
    }
}
