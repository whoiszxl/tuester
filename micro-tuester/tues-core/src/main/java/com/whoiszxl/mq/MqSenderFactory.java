package com.whoiszxl.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MQ发送者创建工厂
 */
@Component
public class MqSenderFactory {

    @Autowired
    private KafkaSender kafkaSender;

    @Autowired
    private RocketMQSender rocketMQSender;

    public MqSender get(MqEnum param) {
        if(param.equals(MqEnum.KAFKA)) {
            return kafkaSender;
        }

        if(param.equals(MqEnum.ROCKETMQ)) {
            return rocketMQSender;
        }

        if(param.equals(MqEnum.DEFAULT)) {
            return kafkaSender;
        }

        return kafkaSender;
    }

}