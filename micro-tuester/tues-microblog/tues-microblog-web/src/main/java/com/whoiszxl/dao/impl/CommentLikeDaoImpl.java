package com.whoiszxl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.whoiszxl.dao.CommentLikeDao;
import com.whoiszxl.entity.CommentLike;
import com.whoiszxl.repository.CommentLikeRepository;

@Repository
public class CommentLikeDaoImpl implements CommentLikeDao {

	@Autowired
	private CommentLikeRepository commentLikeRepository;
	
	@Override
	public List<CommentLike> saveAll(Iterable<CommentLike> var1) {
		return commentLikeRepository.saveAll(var1);
	}

}
