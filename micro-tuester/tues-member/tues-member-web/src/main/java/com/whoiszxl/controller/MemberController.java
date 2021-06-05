package com.whoiszxl.controller;

import com.whoiszxl.bean.Result;
import com.whoiszxl.dto.MemberFeignDTO;
import com.whoiszxl.feign.MemberFeign;
import com.whoiszxl.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "会员控制器")
@RestController
@RequestMapping("/member")
public class MemberController implements MemberFeign {


    @Autowired
    private MemberService memberService;

    @ApiOperation("获取当前登录用户的详细信息.")
    @PostMapping("/detail")
    public Result<MemberFeignDTO> memberDetail() {
        return Result.buildSuccess(memberService.memberInfo());
    }
    
    
    @Override
    public MemberFeignDTO memberInfo() {
        return memberService.memberInfo();
    }
    
    

}
