package com.whoiszxl.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 微博文章表
 * 
 * @author whoiszxl
 * @email whoiszxl@gmail.com
 * @date 2021-06-05 12:04:17
 */
@Data
@Table(name = "wb_micro_blog")
@Entity
public class MicroBlog implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 微博主键ID
	 */
	@Id
	private Long id;
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
	 * 文字内容
	 */
	private String blogText;
	/**
	 * 图片内容
	 */
	private String blogImgs;
	/**
	 * 视频内容
	 */
	private String blogVideo;
	/**
	 * @了谁，下划线分割
	 */
	private String at;
	/**
	 * 浏览数
	 */
	private Integer watchCount;
	/**
	 * 点赞数
	 */
	private Integer likeCount;
	/**
	 * 评论数
	 */
	private Integer commentCount;
	/**
	 * 来自什么渠道
	 */
	private String channel;
	/**
	 * 地址
	 */
	private String address;
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
