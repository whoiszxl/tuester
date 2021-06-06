package com.whoiszxl.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Kafka发送者
 */
@Component
public class KafkaSender implements MqSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}