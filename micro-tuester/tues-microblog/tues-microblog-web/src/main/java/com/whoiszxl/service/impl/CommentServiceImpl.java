package com.whoiszxl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whoiszxl.bean.Result;
import com.whoiszxl.dao.BlogCommentDao;
import com.whoiszxl.dto.MemberFeignDTO;
import com.whoiszxl.entity.BlogComment;
import com.whoiszxl.entity.params.BlogDeleteParam;
import com.whoiszxl.entity.params.CommentAddParam;
import com.whoiszxl.enums.StatusEnum;
import com.whoiszxl.exception.ExceptionCatcher;
import com.whoiszxl.feign.MemberFeign;
import com.whoiszxl.service.CommentService;
import com.whoiszxl.utils.BeanCopierUtils;
import com.whoiszxl.utils.DateProvider;
import com.whoiszxl.utils.IdWorker;
import com.whoiszxl.utils.JwtUtils;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private BlogCommentDao blogCommentDao;
	
	@Autowired
	private IdWorker idWorker;
	
    @Autowired
    private MemberFeign memberFeign;
    
    @Autowired
    private DateProvider dateProvider;
	
	
	@Override
	public int add(CommentAddParam commentAddParam) {
		//1. 校验微博
        if(!verifyBlogText(commentAddParam.getCommentText())) {
            ExceptionCatcher.catchValidateEx(Result.buildError("微博参数错误"));
        }

        //2. 获取用户信息
        Long memberId = JwtUtils.getMemberId();

        //3. 获取用户资料
        MemberFeignDTO memberInfo = memberFeign.memberInfo();

        BlogComment blogComment = new BlogComment();
        BeanCopierUtils.copyProperties(commentAddParam, blogComment);
        blogComment.setMemberId(memberId);
        blogComment.setId(idWorker.nextId());
        blogComment.setMemberNickname(memberInfo.getNickname());
        blogComment.setMemberAvatar(memberInfo.getAvatar());
        blogComment.setLikeCount(0);
        blogComment.setStatus(StatusEnum.OPEN.getCode());
        blogComment.setCreatedAt(dateProvider.dateNow());
        blogComment.setUpdatedAt(dateProvider.dateNow());
        blogCommentDao.saveAndFlush(blogComment);
        return 1;
	}
	
    @Override
    @Transactional
    public int delete(BlogDeleteParam blogDeleteParam) {
        Long memberId = JwtUtils.getMemberId();
        return blogCommentDao.deleteBlogCommentByIdAndMemberId(blogDeleteParam.getId(), memberId);
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
