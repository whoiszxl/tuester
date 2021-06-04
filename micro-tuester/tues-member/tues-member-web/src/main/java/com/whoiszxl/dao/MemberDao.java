package com.whoiszxl.dao;

import com.whoiszxl.entity.Member;

public interface MemberDao {

    /**
     * 通过会员Id查找会员详情
     * @param id 会员ID
     * @return
     */
    Member findById(Long id);

}
