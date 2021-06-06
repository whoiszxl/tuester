package com.whoiszxl.service;

import com.whoiszxl.entity.params.BlogLikeParam;

/**
 * 点赞服务
 * @author whoiszxl
 *
 */
public interface LikeService {

	/**
	 * 对微博或评论点赞或取消点赞
	 * @param blogLikeParam
	 * @return
	 */
	int like(BlogLikeParam blogLikeParam);

}
