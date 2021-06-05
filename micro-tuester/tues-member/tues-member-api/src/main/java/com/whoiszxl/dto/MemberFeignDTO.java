package com.whoiszxl.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MemberFeignDTO {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 会员名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 谷歌验证码
     */
    private String googleKey;
    /**
     * 谷歌验证码是否开启，默认0不开启, 1开启
     */
    private Integer googleStatus;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String phone;
    /**
     * 是否在线(0：离线 1：在线)
     */
    private Integer online;
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
    /**
     * 头像
     */
    private String profilePhoto;
    /**
     * 性别(0:未知 1:男；2:女)
     */
    private Integer gender;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 国家码
     */
    private String countryCode;
    /**
     * 国家
     */
    private String country;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区域
     */
    private String district;
    /**
     * 会员等级
     */
    private String gradeLevel;
    /**
     * 会员登录次数
     */
    private Integer loginCount;
    /**
     * 会员登录错误次数
     */
    private Integer loginErrorCount;
    /**
     * 最后登录
     */
    private Date lastLogin;

}
