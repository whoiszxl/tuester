package com.whoiszxl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态类型
 * @author whoiszxl
 * @date 2021/3/17
 */
@Getter
@AllArgsConstructor
public enum BlogLikeEnum {

    BLOG(1, "微博", -1, 1),
    COMMENT(2, "评论", -1, 1),
    ;
    private Integer code;
    private String desc;
    private Integer unlikeCode;
    private Integer likeCode;
}