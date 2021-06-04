package com.whoiszxl.dao.impl;

import com.whoiszxl.dao.MemberInfoDao;
import com.whoiszxl.entity.MemberInfo;
import com.whoiszxl.repository.MemberInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberInfoDaoImpl implements MemberInfoDao {

    @Autowired
    private MemberInfoRepository memberInfoRepository;

    @Override
    public MemberInfo findByMemberId(Long memberId) {
        return memberInfoRepository.findByMemberId(memberId);
    }
}
