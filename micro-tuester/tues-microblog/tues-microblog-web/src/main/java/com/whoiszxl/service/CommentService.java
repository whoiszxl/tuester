package com.whoiszxl.service;

import com.whoiszxl.entity.params.BlogDeleteParam;
import com.whoiszxl.entity.params.CommentAddParam;

/**
 * 评论服务
 * @author whoiszxl
 *
 */
public interface CommentService {

	/**
	 * 新增评论
	 * @param commentAddParam
	 * @return
	 */
	int add(CommentAddParam commentAddParam);

	/**
	 * 删除评论
	 * @param blogDeleteParam
	 * @return
	 */
    int delete(BlogDeleteParam blogDeleteParam);
}
