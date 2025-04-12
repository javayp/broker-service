package com.app.broker.infrastructure.messaging.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic parentOrderTopic(){
        return TopicBuilder.name("parent-order-topic")
                .partitions(3)
                .replicas(3)
                .build();
    }

    @Bean
    public NewTopic subOrderTopic(){
        return TopicBuilder.name("sub-order-topic")
                .partitions(3)
                .replicas(3)
                .build();
    }


}
