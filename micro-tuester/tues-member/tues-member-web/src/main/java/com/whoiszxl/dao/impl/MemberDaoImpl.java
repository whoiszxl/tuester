package com.whoiszxl.dao.impl;

import com.whoiszxl.dao.MemberDao;
import com.whoiszxl.entity.Member;
import com.whoiszxl.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id).get();
    }
}
