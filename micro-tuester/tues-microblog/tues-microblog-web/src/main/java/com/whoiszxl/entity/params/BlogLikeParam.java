package com.whoiszxl.entity.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("微博或评论点赞参数")
public class BlogLikeParam {

    @ApiModelProperty("微博或评论ID")
    private Long id;

    @ApiModelProperty(value = "用户ID", hidden = true)
    private Long memberId;

    @ApiModelProperty("类型：1：微博 2：评论")
    private Integer type;
    
    @ApiModelProperty("-1：取消点赞 1：点赞")
    private Integer status;

    @ApiModelProperty(value = "时间戳", hidden = true)
    private Long timestamp;
}
