package com.whoiszxl.dao;

import java.util.List;

import com.whoiszxl.entity.CommentLike;

/**
 * 微博评论点赞dao
 */
public interface CommentLikeDao {

	List<CommentLike> saveAll(Iterable<CommentLike> var1);
}