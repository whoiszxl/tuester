package com.whoiszxl.service.impl;

import com.whoiszxl.constants.KafkaTopicConstants;
import com.whoiszxl.entity.params.BlogLikeParam;
import com.whoiszxl.mq.MqEnum;
import com.whoiszxl.mq.MqSenderFactory;
import com.whoiszxl.service.LikeService;
import com.whoiszxl.utils.DateProvider;
import com.whoiszxl.utils.JsonUtil;
import com.whoiszxl.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private MqSenderFactory mqSenderFactory;

	@Autowired
	private DateProvider dateProvider;

	/**
	 * 点赞or取消点赞，通过发送消息队列异步方式进行操作
	 * @param blogLikeParam 点赞参数
	 * @return
	 */
	@Override
	public int like(BlogLikeParam blogLikeParam) {
		Long memberId = JwtUtils.getMemberId();
		blogLikeParam.setMemberId(memberId);
		blogLikeParam.setTimestamp(dateProvider.nowTimeStamp());
		String paramJson = JsonUtil.toJson(blogLikeParam);
		mqSenderFactory.get(MqEnum.DEFAULT).send(KafkaTopicConstants.LIKE_TOPIC, paramJson);
		return 1;
	}
}
