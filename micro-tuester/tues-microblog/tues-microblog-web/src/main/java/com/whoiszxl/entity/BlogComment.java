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
@Table(name = "wb_blog_comment")
@Entity
public class BlogComment implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评论主键ID
	 */
	@Id
	private Long id;
	/**
	 * 微博ID
	 */
	private Long blogId;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 会员昵称
	 */
	private String memberNickname;
	/**
	 * 会员头像
	 */
	private String memberAvatar;
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
	 * 点赞数
	 */
	private Integer likeCount;
	/**
	 * 评论父ID，为0则是主评论
	 */
	private Integer parentId;
	/**
	 * 状态(0：无效 1：有效)
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createdAt;
	/**
	 * 更新时间
	 */
	private Date updatedAt;

}
