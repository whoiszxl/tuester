package com.whoiszxl.controller;

import com.whoiszxl.dto.MemberFeignDTO;
import com.whoiszxl.feign.MemberFeign;
import com.whoiszxl.service.MemberService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "会员控制器")
@RestController
@RequestMapping("/member")
public class MemberController implements MemberFeign {


    @Autowired
    private MemberService memberService;

    @Override
    public MemberFeignDTO memberInfo() {
        return memberService.memberInfo();
    }
}
