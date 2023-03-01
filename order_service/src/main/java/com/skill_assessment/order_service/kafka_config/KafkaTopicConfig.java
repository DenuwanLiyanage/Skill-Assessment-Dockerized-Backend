package com.skill_assessment.order_service.kafka_config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic skillAssessmentTopic(){
        return TopicBuilder.name("skillAssessmentTopic").build();

    }
}
