package com.whoiszxl.repository;

import com.whoiszxl.bean.BaseRepository;
import com.whoiszxl.entity.MicroBlog;

public interface MicroBlogRepository extends BaseRepository<MicroBlog> {


    /***
     * 通过主键ID和memberId进行删除操作
     * @param id 主键ID
     * @param memberId 会员ID
     * @return
     */
    int deleteMicroBlogByIdAndMemberId(Long id, Long memberId);
}
