package com.kafka.provider.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class KafkaController {

   @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping("/mensaje")
    public ResponseEntity<?> sendMessage(@RequestBody Map<String, String> request){
            String message=request.get("message");
        try {
            kafkaTemplate.send("miTopic",message);
            return ResponseEntity.ok("Mesagge sended");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
