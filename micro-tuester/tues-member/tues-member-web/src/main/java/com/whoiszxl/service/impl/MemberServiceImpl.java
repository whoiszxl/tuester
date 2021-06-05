package com.whoiszxl.service.impl;

import com.whoiszxl.dao.MemberDao;
import com.whoiszxl.dao.MemberInfoDao;
import com.whoiszxl.dto.MemberFeignDTO;
import com.whoiszxl.entity.Member;
import com.whoiszxl.entity.MemberInfo;
import com.whoiszxl.entity.vo.MemberDetailVO;
import com.whoiszxl.entity.vo.MemberInfoVO;
import com.whoiszxl.entity.vo.MemberVO;
import com.whoiszxl.service.MemberService;
import com.whoiszxl.utils.BeanCopierUtils;
import com.whoiszxl.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberInfoDao memberInfoDao;

    @Override
    public MemberFeignDTO memberInfo() {
        //从jwt中获取用户ID
        Long memberId = Long.parseLong(JwtUtils.getUsername());
        Member member = memberDao.findById(memberId);
        MemberInfo memberInfo = memberInfoDao.findByMemberId(memberId);

        MemberFeignDTO memberFeignDTO = new MemberFeignDTO();
        BeanCopierUtils.copyProperties(memberInfo, memberFeignDTO);
        BeanCopierUtils.copyProperties(member, memberFeignDTO);
        return memberFeignDTO;
    }
}
