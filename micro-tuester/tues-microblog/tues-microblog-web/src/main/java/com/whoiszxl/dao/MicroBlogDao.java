package com.whoiszxl.dao;

import com.whoiszxl.bean.BaseDao;
import com.whoiszxl.entity.MicroBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 微博文章dao
 */
public interface MicroBlogDao extends BaseDao<MicroBlog, Long> {


    Page<MicroBlog> findAll(Pageable var1);

    /**
     * 通过id和memberId进行删除
     * @param id 主键ID
     * @param memberId 会员ID
     * @return
     */
    int deleteMicroBlogByIdAndMemberId(Long id, Long memberId);
}

