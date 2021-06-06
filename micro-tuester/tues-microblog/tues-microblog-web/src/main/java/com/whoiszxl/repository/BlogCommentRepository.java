package com.whoiszxl.repository;

import com.whoiszxl.bean.BaseRepository;
import com.whoiszxl.entity.BlogComment;

public interface BlogCommentRepository extends BaseRepository<BlogComment> {

	/**
	 * 通过评论主键ID和会员ID删除评论
	 * @param id
	 * @param memberId
	 * @return
	 */
	int deleteBlogCommentByIdAndMemberId(Long id, Long memberId);
	
}
