package com.whoiszxl.service;

import com.whoiszxl.entity.params.LoginParam;
import com.whoiszxl.entity.vo.LoginMemberVO;

public interface MemberLoginService {

    /**
     * 会员登录
     * @param loginParam 登录参数
     * @return
     */
    LoginMemberVO login(LoginParam loginParam);
}
