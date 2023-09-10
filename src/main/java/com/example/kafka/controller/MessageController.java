package com.example.kafka.controller;

import com.example.kafka.config.producer.KafkaProducer;
import com.example.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/api/vi/kafka/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
    @PostMapping("/api/vi/kafka/publishjson")
    public ResponseEntity<String> publishJson(@RequestBody User user){
        kafkaProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Message sent to the topic");
    }


}
