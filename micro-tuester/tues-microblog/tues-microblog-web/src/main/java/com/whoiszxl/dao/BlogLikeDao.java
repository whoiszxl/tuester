package com.whoiszxl.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.whoiszxl.bean.BaseDao;
import com.whoiszxl.entity.BlogComment;
import com.whoiszxl.entity.BlogLike;

/**
 * 微博点赞dao
 */
public interface BlogLikeDao {

    public List<BlogLike> saveAll(Iterable<BlogLike> var1);
}