package com.whoiszxl.consumer;

import com.whoiszxl.constants.KafkaTopicConstants;
import com.whoiszxl.entity.params.BlogLikeParam;
import com.whoiszxl.enums.BlogLikeEnum;
import com.whoiszxl.utils.JsonUtil;
import com.whoiszxl.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * 微博点赞消费者
 */
@Slf4j
@Component
public class BlogLikeConsumer {

    @Autowired
    private RedisUtils redisUtils;

    /**
     * Redis结构设计 - 使用Hash数据结构
     *                                          -- hashKey(用户ID) hashValue(点赞时间)
     * key(点赞类型 + 冒号 + 点赞类型内容主键ID) --
     *                                          -- hashKey(用户ID) hashValue(点赞时间)
     *
     * @param record
     * @param topic
     * @param consumer
     */
    @KafkaListener(topics = KafkaTopicConstants.LIKE_TOPIC, groupId = "default_group")
    public void like(ConsumerRecord<String, String> record,
                     @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                     Consumer consumer) {

        log.debug("订阅到新的点赞请求，开始处理, 主题为：{}， 消息值为：{}", topic, record.value());

        //1. 获取消息体
        BlogLikeParam blogLikeParam = JsonUtil.fromJson(record.value(), BlogLikeParam.class);
        if(ObjectUtils.isEmpty(blogLikeParam) || blogLikeParam.getId() == null) {
            return;
        }

        //2. 对消息进行处理，操作Redis
        if(blogLikeParam.getType().equals(BlogLikeEnum.BLOG.getCode())) {
            String key = BlogLikeEnum.BLOG.toString().toLowerCase() + ":" + blogLikeParam.getId();
            //2.1 消息是微博点赞类型
            if(blogLikeParam.getStatus().equals(BlogLikeEnum.BLOG.getLikeCode())) {
                redisUtils.hPut(key, blogLikeParam.getMemberId().toString(), blogLikeParam.getTimestamp().toString());
                //set中存一份，方便后续入库使用
                redisUtils.sAdd(BlogLikeEnum.BLOG.toString().toLowerCase() + "set", key);
            }
            //2.2 消息是微博取消点赞类型
            if(blogLikeParam.getStatus().equals(BlogLikeEnum.BLOG.getUnlikeCode())) {
                redisUtils.hDelete(key, blogLikeParam.getMemberId().toString());
            }
        }
        
        if(blogLikeParam.getType().equals(BlogLikeEnum.COMMENT.getCode())) {
        	String key = BlogLikeEnum.COMMENT.toString().toLowerCase() + ":" + blogLikeParam.getId();
        	//2.3 消息是评论微博点赞类型
            if(blogLikeParam.getStatus().equals(BlogLikeEnum.COMMENT.getLikeCode())) {
                redisUtils.hPut(key, blogLikeParam.getMemberId().toString(), blogLikeParam.getTimestamp().toString());
                //set中存一份，方便后续入库使用
                redisUtils.sAdd(BlogLikeEnum.BLOG.toString().toLowerCase() + "set", key);
            }
            //2.4 消息是微博取消点赞类型
            if(blogLikeParam.getStatus().equals(BlogLikeEnum.COMMENT.getUnlikeCode())) {
                redisUtils.hDelete(key, blogLikeParam.getMemberId().toString());
            }
        }
    }


}
