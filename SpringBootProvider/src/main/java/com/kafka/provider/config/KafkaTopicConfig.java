package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){

        Map<String,String> configurations=new HashMap<>();

        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); //con delete borra el mensaje
        configurations.put(TopicConfig.RETENTION_MS_CONFIG,"86400000"); //tiempo que dura el mensaje antes de borrarse
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG,"1073741824");//tamaño maximo de segmento
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG,"100000012"); //tamañno maximo de cada mensaje por defecto 1 mega

        return TopicBuilder.name("miTopic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();

    }
}
