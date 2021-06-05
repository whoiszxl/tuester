package com.whoiszxl.service;

import com.whoiszxl.dto.MemberFeignDTO;

public interface MemberService {

    /**
     * 会员信息查询
     * @return
     */
    MemberFeignDTO memberInfo();
}
