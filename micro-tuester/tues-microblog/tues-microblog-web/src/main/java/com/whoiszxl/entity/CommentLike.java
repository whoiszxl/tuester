package com.whoiszxl.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 评论点赞表
 * 
 * @author whoiszxl
 * @email whoiszxl@gmail.com
 * @date 2021-06-05 12:04:18
 */
@Data
@Table(name = "wb_comment_like")
@Entity
public class CommentLike implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@Id
	private Long id;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 状态(1：点赞 0：取消赞)
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createdAt;

}
