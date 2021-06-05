package com.whoiszxl.entity.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("微博更新参数")
public class BlogUpdateParam {

    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("文字内容")
    private String blogText;

    @ApiModelProperty("图片内容")
    private String blogImgs;

    @ApiModelProperty("视频内容")
    private String blogVideo;

    @ApiModelProperty("@了谁，下划线分割")
    private String at;

    @ApiModelProperty("来自什么渠道")
    private String from;

    @ApiModelProperty("地址")
    private String address;
}
