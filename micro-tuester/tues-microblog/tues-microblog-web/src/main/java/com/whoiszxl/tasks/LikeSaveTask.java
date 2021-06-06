package com.whoiszxl.tasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.whoiszxl.dao.BlogLikeDao;
import com.whoiszxl.dao.CommentLikeDao;
import com.whoiszxl.entity.BlogLike;
import com.whoiszxl.entity.CommentLike;
import com.whoiszxl.enums.BlogLikeEnum;
import com.whoiszxl.utils.RedisUtils;

@Component
@Configuration
@EnableScheduling
public class LikeSaveTask {

	@Autowired
	private BlogLikeDao blogLikeDao;
	
	@Autowired
	private CommentLikeDao commentLikeDao;
	
	@Autowired
	private RedisUtils redisUtils;
    
    //@Scheduled(cron = "0 0 1 * * ? *") 每天一点执行一次，生产环境使用
    //测试环境设置一分钟一次
    @Scheduled(fixedRate = 1000 * 60)
    private void likeSaveTask() {
    	//1. 从Redis中取出所有被点赞过的记录
    	String blogSetName = BlogLikeEnum.BLOG.toString().toLowerCase() + "set";
    	String commentSetName = BlogLikeEnum.COMMENT.toString().toLowerCase() + "set";
    	
    	Set<String> blogKeys = redisUtils.sMembers(blogSetName);
    	Set<String> commentKeys = redisUtils.sMembers(commentSetName);
    	
    	List<BlogLike> blogLikeList = new ArrayList<>();
    	
    	//TODO 需要分批
    	Iterator<String> blogIt = blogKeys.iterator();
    	while(blogIt.hasNext()) {
    		String blogLikeTitle = blogIt.next();
    		Map<String, String> blogLikeMap = redisUtils.hGetAll(blogLikeTitle);
    		blogLikeMap.forEach((memberId, timestamp) -> {
    			BlogLike blogLike = new BlogLike();
    			blogLike.setMemberId(Long.parseLong(memberId));
    			blogLike.setCreatedAt(new Date(Long.parseLong(timestamp)));
    			blogLikeList.add(blogLike);
    		});
    	}
    	
    	blogLikeDao.saveAll(blogLikeList);
    	
    	
    	List<CommentLike> commentLikeList = new ArrayList<>();
    	Iterator<String> commentIt = commentKeys.iterator();
    	while(commentIt.hasNext()) {
    		String commentLikeTitle = commentIt.next();
    		Map<String, String> commentLikeMap = redisUtils.hGetAll(commentLikeTitle);
    		commentLikeMap.forEach((memberId, timestamp) -> {
    			CommentLike commentLike = new CommentLike();
    			commentLike.setMemberId(Long.parseLong(memberId));
    			commentLike.setCreatedAt(new Date(Long.parseLong(timestamp)));
    			commentLikeList.add(commentLike);
    		});
    	}
    	
    	commentLikeDao.saveAll(commentLikeList);
    }
	
}
