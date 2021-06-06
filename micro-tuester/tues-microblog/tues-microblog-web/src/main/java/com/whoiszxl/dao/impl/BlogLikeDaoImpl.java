package com.whoiszxl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.whoiszxl.dao.BlogLikeDao;
import com.whoiszxl.entity.BlogLike;
import com.whoiszxl.repository.BlogLikeRepository;

@Repository
public class BlogLikeDaoImpl implements BlogLikeDao {
	
	@Autowired
	private BlogLikeRepository blogLikeRepository;

	@Override
	public List<BlogLike> saveAll(Iterable<BlogLike> var1) {
		return blogLikeRepository.saveAll(var1);
	}
	
}
