package com.whoiszxl.entity.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("微博删除参数")
public class BlogDeleteParam {

    @ApiModelProperty("微博ID")
    private Long id;
}
