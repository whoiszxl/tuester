package com.whoiszxl.controller;

import com.whoiszxl.bean.Result;
import com.whoiszxl.entity.vo.MemberDetailVO;
import com.whoiszxl.service.MemberService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "会员控制器")
@RestController
public class MemberController {


    @Autowired
    private MemberService memberService;

    @PostMapping("/member/info")
    public Result<MemberDetailVO> memberInfo() {
        MemberDetailVO memberInfoVO = memberService.memberInfo();
        return Result.buildSuccess(memberInfoVO);
    }

}
