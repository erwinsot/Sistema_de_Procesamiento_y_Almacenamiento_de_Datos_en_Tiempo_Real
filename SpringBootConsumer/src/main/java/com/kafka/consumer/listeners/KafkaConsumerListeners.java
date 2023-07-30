package com.kafka.consumer.listeners;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListeners {
    private Logger LOGGER= LoggerFactory.getLogger(KafkaConsumerListeners.class);


    @KafkaListener(topics = {"miTopic"}, groupId = "myGroupId")
    public void listener(String message){

        LOGGER.info("mensaje recibido: "+ message);

    }
}
