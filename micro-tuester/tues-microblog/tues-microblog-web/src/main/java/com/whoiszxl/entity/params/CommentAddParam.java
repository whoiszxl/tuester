package com.whoiszxl.entity.params;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("评论新增参数")
public class CommentAddParam {

	/**
	 * 微博ID
	 */
	private Long blogId;
	/**
	 * 评论内容
	 */
	private String commentText;
	/**
	 * 评论图片
	 */
	private String commentImgs;
	/**
	 * @了谁，下划线分割
	 */
	private String at;
	/**
	 * 评论父ID，为0则是主评论
	 */
	private Integer parentId;
	
}
