package com.whoiszxl.service;

import com.whoiszxl.bean.MyPage;
import com.whoiszxl.bean.PageParam;
import com.whoiszxl.entity.MicroBlog;
import com.whoiszxl.entity.dto.MicroBlogDTO;
import com.whoiszxl.entity.params.BlogAddParam;
import com.whoiszxl.entity.params.BlogDeleteParam;
import com.whoiszxl.entity.params.BlogUpdateParam;

import java.util.List;

/**
 * 微博文章服务
 */

public interface MicroBlogService {
    /**
     * 分页查询当前用户微博列表
     * @param pageParam 分页参数
     * @return
     */
    MyPage<MicroBlog> listForPage(PageParam pageParam);

    /**
     * 新增微博
     * @param blogAddParam 新增微博参数
     * @return
     */
    int add(BlogAddParam blogAddParam);

    /**
     * 更新微博
     * @param blogUpdateParam 更新微博参数
     * @return
     */
    int update(BlogUpdateParam blogUpdateParam);

    /**
     * 删除微博
     * @param blogDeleteParam 删除微博参数
     * @return
     */
    int delete(BlogDeleteParam blogDeleteParam);
}
