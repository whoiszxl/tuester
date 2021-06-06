package com.whoiszxl.mq;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MqEnum {

    DEFAULT("DEFAULT", "默认消息队列 kafka"),
    KAFKA("KAFKA", "kafka消息队列"),
    ROCKETMQ("ROCKETMQ", "rocket mq消息队列");

    private final String name;
    private final String desc;
}