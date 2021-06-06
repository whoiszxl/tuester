package com.whoiszxl.mq;

import org.springframework.stereotype.Component;

/**
 * RocketMQ发送者
 */
@Component
public class RocketMQSender implements MqSender{

    @Override
    public void send(String topic, String message) {

    }
}