package com.whoiszxl.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.whoiszxl.bean.BaseDao;
import com.whoiszxl.entity.BlogComment;

/**
 * 微博文章评论dao
 */
public interface BlogCommentDao extends BaseDao<BlogComment, Long> {

	/**
	 * 分页查询所有评论
	 * @param pageable
	 * @return
	 */
    public Page<BlogComment> findAll(Pageable pageable);
    
	/**
	 * 通过评论主键ID和会员ID删除评论
	 * @param id
	 * @param memberId
	 * @return
	 */
	int deleteBlogCommentByIdAndMemberId(Long id, Long memberId);
}