---------------------------------------------------
--------------微博模块-----------------------------
---------------------------------------------------
DROP TABLE IF EXISTS `wb_micro_blog`;
    CREATE TABLE `wb_micro_blog`(
        `id` int(11) NOT NULL COMMENT '微博主键ID',
        `member_id` int(11) NOT NULL COMMENT '会员ID',
        `member_nickname` varchar(100) NOT NULL DEFAULT '' COMMENT '会员昵称',
        `member_avatar` varchar(200) NOT NULL DEFAULT '' COMMENT '会员头像',
        `blog_text` varchar(140) NOT NULL COMMENT '文字内容',
        `blog_imgs` varchar(2000) NOT NULL COMMENT '图片内容',
        `blog_video` varchar(300) NOT NULL COMMENT '视频内容',
        `at` varchar(150) NOT NULL DEFAULT '' COMMENT '@了谁，下划线分割', 
        `watch_count` int(11) NOT NULL DEFAULT 0 COMMENT '浏览数',
        `like_count` int(11) NOT NULL DEFAULT 0 COMMENT '点赞数',
        `comment_count` int(11) DEFAULT 0 NOT NULL COMMENT '评论数',
        `channel` varchar(10) NOT NULL DEFAULT '' COMMENT '来自什么渠道',
        `address` varchar(100) NOT NULL DEFAULT '' COMMENT '地址',
        `status` tinyint(1) DEFAULT 1 COMMENT '状态(0：无效 1：有效)',
        `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
        `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '微博文章表';

DROP TABLE IF EXISTS `wb_blog_comment`;
CREATE TABLE `wb_blog_comment`(
    `id` int(11) NOT NULL COMMENT '评论主键ID',
    `blog_id` int(11) NOT NULL COMMENT '微博ID',
    `member_id` int(11) NOT NULL COMMENT '会员ID',
    `member_nickname` varchar(100) NOT NULL COMMENT '会员昵称',
    `member_avatar` varchar(200) NOT NULL COMMENT '会员头像',
    `comment_text` varchar(140) NOT NULL COMMENT '评论内容',
    `comment_imgs` varchar(150) NOT NULL COMMENT '评论图片',
    `at` varchar(150) NOT NULL DEFAULT '' COMMENT '@了谁，下划线分割', 
    `like` int(11) NOT NULL COMMENT '点赞数',
    `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '评论父ID，为0则是主评论',
    `status` tinyint(1) DEFAULT 1 COMMENT '状态(0：无效 1：有效)',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '微博点赞表';

DROP TABLE IF EXISTS `wb_topic`;
CREATE TABLE `wb_topic`(
    `id` int(11) NOT NULL COMMENT '主题主键ID',
    `title` varchar(100) NOT NULL COMMENT '主题标题',
    `watch` int(12) NOT NULL COMMENT '阅读数',
    `count` int(11) NOT NULL COMMENT '讨论数',
    `status` tinyint(1) DEFAULT 1 COMMENT '状态(0：无效 1：有效)',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '微博主题表';

DROP TABLE IF EXISTS `wb_blog_like`;
CREATE TABLE `wb_blog_like`(
    `member_id` int(11) NOT NULL COMMENT '会员ID',
    `status` tinyint(1) DEFAULT 1 COMMENT '状态(1：点赞 0：取消赞)',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '微博点赞表';

DROP TABLE IF EXISTS `wb_comment_like`;
CREATE TABLE `wb_comment_like`(
    `member_id` int(11) NOT NULL COMMENT '会员ID',
    `status` tinyint(1) DEFAULT 1 COMMENT '状态(1：点赞 0：取消赞)',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '评论点赞表';


