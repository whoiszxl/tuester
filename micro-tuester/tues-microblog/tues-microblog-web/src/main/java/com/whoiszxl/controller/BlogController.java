package com.whoiszxl.controller;

import com.whoiszxl.bean.MyPage;
import com.whoiszxl.bean.PageParam;
import com.whoiszxl.bean.Result;
import com.whoiszxl.entity.MicroBlog;
import com.whoiszxl.entity.dto.MicroBlogDTO;
import com.whoiszxl.entity.params.BlogAddParam;
import com.whoiszxl.entity.params.BlogDeleteParam;
import com.whoiszxl.entity.params.BlogUpdateParam;
import com.whoiszxl.entity.vo.MicroBlogVO;
import com.whoiszxl.service.MicroBlogService;
import com.whoiszxl.utils.BeanCopierUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "微博文章控制器")
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private MicroBlogService microBlogService;


    @ApiOperation("获取当前用户的微博列表")
    @PostMapping("/list")
    public Result<MyPage<MicroBlogVO>> list(@RequestBody PageParam pageParam) {
        MyPage<MicroBlog> result = microBlogService.listForPage(pageParam);
        List<MicroBlogVO> microBlogVOList = BeanCopierUtils.copyListProperties(result.getContent(), MicroBlogVO::new);
        MyPage<MicroBlogVO> finalResult = new MyPage<>();
        finalResult.setFirst(result.isFirst());
        finalResult.setNumber(result.getNumber());
        finalResult.setSize(result.getSize());
        finalResult.setTotalPages(result.getTotalPages());
        finalResult.setContent(microBlogVOList);
        return Result.buildSuccess(finalResult);
    }

    @ApiOperation("新增微博")
    @PostMapping("/add")
    public Result<String> add(@RequestBody BlogAddParam blogAddParam) {
        int i = microBlogService.add(blogAddParam);
        return i == 0 ? Result.buildError() : Result.buildSuccess();
    }

    @ApiOperation("更新微博")
    @PutMapping("/update")
    public Result<String> update(@RequestBody BlogUpdateParam blogUpdateParam) {
        int i = microBlogService.update(blogUpdateParam);
        return i == 0 ? Result.buildError() : Result.buildSuccess();
    }

    @ApiOperation("删除微博")
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestBody BlogDeleteParam blogDeleteParam) {
        int i = microBlogService.delete(blogDeleteParam);
        return i == 0 ? Result.buildError() : Result.buildSuccess();
    }
}
