package com.whoiszxl.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 微博点赞表
 * 
 * @author whoiszxl
 * @email whoiszxl@gmail.com
 * @date 2021-06-05 12:04:17
 */
@Data
@Table(name = "wb_blog_like")
@Entity
public class BlogLike implements Serializable {
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
