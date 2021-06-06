package com.whoiszxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whoiszxl.bean.Result;
import com.whoiszxl.entity.params.BlogLikeParam;
import com.whoiszxl.entity.params.CommentAddParam;
import com.whoiszxl.service.LikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 评论控制器
 * @author whoiszxl
 *
 */
@Api(tags = "点赞控制器")
@RestController
@RequestMapping("/like")
public class LikeController {

	@Autowired
	private LikeService likeService;
	
	
    @ApiOperation("点赞")
    @PostMapping
    public Result<String> like(@RequestBody BlogLikeParam blogLikeParam) {
        int i = likeService.like(blogLikeParam);
        return i == 0 ? Result.buildError() : Result.buildSuccess();
    }
	
}
