package com.whoiszxl.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 微博主题表
 * 
 * @author whoiszxl
 * @email whoiszxl@gmail.com
 * @date 2021-06-05 12:04:17
 */
@Data
public class TopicDTO implements Serializable {

	/**
	 * 主题主键ID
	 */
	private Integer id;
	/**
	 * 主题标题
	 */
	private String title;
	/**
	 * 阅读数
	 */
	private Integer watch;
	/**
	 * 讨论数
	 */
	private Integer count;
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
