---------------------------------------------------
--------------微博模块-----------------------------
---------------------------------------------------
DROP TABLE IF EXISTS `wb_micro_blog`;
CREATE TABLE `wb_micro_blog`(
    `id` int(11) NOT NULL COMMENT '微博主键ID',
    `member_id` int(11) NOT NULL COMMENT '会员ID',
    `blog_text` varchar(140) NOT NULL COMMENT '文字内容',
    `blog_imgs` varchar(2000) NOT NULL COMMENT '图片内容',
    `blog_video` varchar(300) NOT NULL COMMENT '视频内容',
    `watch` int(11) NOT NULL COMMENT '浏览数',
    `like` int(11) NOT NULL COMMENT '点赞数',
    `from` varchar(10) NOT NULL COMMENT '来自什么渠道',
    `address` varchar(100) NOT NULL COMMENT '地址',
    `status` tinyint(2) DEFAULT 1 COMMENT '状态(0：无效 1：有效)',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '微博文章表';