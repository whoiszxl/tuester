package com.whoiszxl.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论点赞表
 * 
 * @author whoiszxl
 * @email whoiszxl@gmail.com
 * @date 2021-06-05 12:04:18
 */
@Data
public class CommentLikeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Integer id;
	/**
	 * 会员ID
	 */
	private Integer memberId;
	/**
	 * 状态(1：点赞 0：取消赞)
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createdAt;

}
