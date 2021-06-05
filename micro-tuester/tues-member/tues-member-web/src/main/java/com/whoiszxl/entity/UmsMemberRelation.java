package com.whoiszxl.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 微博会员关系表
 * 
 * @author whoiszxl
 * @email whoiszxl@gmail.com
 * @date 2021-06-05 12:04:17
 */
@Data
@Table(name = "ums_member_relation")
@Entity
public class UmsMemberRelation implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@Id
	private Integer id;
	/**
	 * 性别(0:未知 1:男；2:女)
	 */
	private Integer fromMemberId;
	/**
	 * 生日
	 */
	private Integer toMemberId;
	/**
	 * 关系：1 from关注to， 2 from是to的粉丝， 3 from和to互关
	 */
	private Integer relation;
	/**
	 * to方昵称
	 */
	private String toNickname;
	/**
	 * to方简介
	 */
	private String toIntro;
	/**
	 * 创建时间
	 */
	private Date createdAt;
	/**
	 * 更新时间
	 */
	private Date updatedAt;

}
