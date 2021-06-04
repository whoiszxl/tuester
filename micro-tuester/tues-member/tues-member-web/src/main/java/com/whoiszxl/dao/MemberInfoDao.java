package com.whoiszxl.dao;

import com.whoiszxl.entity.MemberInfo;

public interface MemberInfoDao {

    /**
     * 通过会员Id查找会员详情
     * @param memberId 会员ID
     * @return
     */
    MemberInfo findByMemberId(Long memberId);
}
