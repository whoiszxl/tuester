package com.whoiszxl.service.impl;

import com.whoiszxl.bean.MyPage;
import com.whoiszxl.bean.PageParam;
import com.whoiszxl.bean.Result;
import com.whoiszxl.dao.MicroBlogDao;
import com.whoiszxl.dto.MemberFeignDTO;
import com.whoiszxl.entity.MicroBlog;
import com.whoiszxl.entity.params.BlogAddParam;
import com.whoiszxl.entity.params.BlogDeleteParam;
import com.whoiszxl.entity.params.BlogUpdateParam;
import com.whoiszxl.enums.StatusEnum;
import com.whoiszxl.exception.ExceptionCatcher;
import com.whoiszxl.feign.MemberFeign;
import com.whoiszxl.service.MicroBlogService;
import com.whoiszxl.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MicroBlogServiceImpl implements MicroBlogService {

    @Autowired
    private MicroBlogDao microBlogDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MemberFeign memberFeign;

    @Autowired
    private DateProvider dateProvider;


    @Override
    public MyPage<MicroBlog> listForPage(PageParam pageParam) {
        Pageable pageable = JpaUtils.getPageable(pageParam.getPageNumber(), pageParam.getPageSize(), JpaUtils.getSort(-1, "createdAt"));
        Page<MicroBlog> microBlogPages = microBlogDao.findAll(pageable);
        return JpaUtils.convertMyPage(microBlogPages);
    }

    @Override
    @Transactional
    public int add(BlogAddParam blogAddParam) {
        //1. 校验微博
        if(!verifyBlogText(blogAddParam.getBlogText())) {
            ExceptionCatcher.catchValidateEx(Result.buildError("微博参数错误"));
        }

        //2. 获取用户信息
        Long memberId = JwtUtils.getMemberId();

        //3. 获取用户资料
        MemberFeignDTO memberInfo = memberFeign.memberInfo();

        MicroBlog microBlog = new MicroBlog();
        BeanCopierUtils.copyProperties(blogAddParam, microBlog);
        microBlog.setMemberId(memberId);
        microBlog.setId(idWorker.nextId());
        microBlog.setMemberNickname(memberInfo.getNickname());
        microBlog.setMemberAvatar(memberInfo.getAvatar());
        microBlog.setCommentCount(0);
        microBlog.setLikeCount(0);
        microBlog.setWatchCount(0);
        microBlog.setStatus(StatusEnum.OPEN.getCode());
        microBlog.setCreatedAt(dateProvider.dateNow());
        microBlog.setUpdatedAt(dateProvider.dateNow());
        microBlogDao.saveAndFlush(microBlog);

        return 1;
    }


    @Override
    @Transactional
    public int update(BlogUpdateParam blogUpdateParam) {
        if(!verifyBlogText(blogUpdateParam.getBlogText())) {
            ExceptionCatcher.catchValidateEx(Result.buildError("微博参数错误"));
        }

        Long memberId = JwtUtils.getMemberId();
        MicroBlog microBlog = new MicroBlog();
        BeanCopierUtils.copyProperties(blogUpdateParam, microBlog);
        microBlog.setMemberId(memberId);
        microBlogDao.saveAndFlush(microBlog);
        return 1;
    }

    @Override
    @Transactional
    public int delete(BlogDeleteParam blogDeleteParam) {
        Long memberId = JwtUtils.getMemberId();
        return microBlogDao.deleteMicroBlogByIdAndMemberId(blogDeleteParam.getId(), memberId);
    }


    /**
     * TODO 校验微博参数是否有效
     * @param blogText
     * @return
     */
    private boolean verifyBlogText(String blogText) {
        return true;
    }
}
