package com.whoiszxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whoiszxl.bean.Result;
import com.whoiszxl.entity.params.BlogAddParam;
import com.whoiszxl.entity.params.CommentAddParam;
import com.whoiszxl.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 评论控制器
 * @author whoiszxl
 *
 */
@Api(tags = "评论控制器")
@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;

    @ApiOperation("新增评论")
    @PostMapping("/add")
    public Result<String> add(@RequestBody CommentAddParam commentAddParam) {
        int i = commentService.add(commentAddParam);
        return i == 0 ? Result.buildError() : Result.buildSuccess();
    }
}
