---------------------------------------------------
--------------微博模块-----------------------------
---------------------------------------------------
DROP TABLE IF EXISTS `wb_micro_blog`;
    CREATE TABLE `wb_micro_blog`(
        `id` int(20) NOT NULL COMMENT '微博主键ID',
        `member_id` bigint(11) NOT NULL COMMENT '会员ID',
        `member_nickname` varchar(100) NOT NULL DEFAULT '' COMMENT '会员昵称',
        `member_avatar` varchar(200) NOT NULL DEFAULT '' COMMENT '会员头像',
        `blog_text` varchar(140) NOT NULL COMMENT '文字内容',
        `blog_imgs` varchar(2000) NOT NULL COMMENT '图片内容',
        `blog_video` varchar(300) NOT NULL COMMENT '视频内容',
        `at` varchar(150) NOT NULL DEFAULT '' COMMENT '@了谁，下划线分割', 
        `watch_count` bigint(11) NOT NULL DEFAULT 0 COMMENT '浏览数',
        `like_count` bigint(11) NOT NULL DEFAULT 0 COMMENT '点赞数',
        `comment_count` bigint(11) DEFAULT 0 NOT NULL COMMENT '评论数',
        `channel` varchar(10) NOT NULL DEFAULT '' COMMENT '来自什么渠道',
        `address` varchar(100) NOT NULL DEFAULT '' COMMENT '地址',
        `status` tinyint(1) DEFAULT 1 COMMENT '状态(0：无效 1：有效)',
        `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
        `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '微博文章表';

DROP TABLE IF EXISTS `wb_blog_comment`;
CREATE TABLE `wb_blog_comment`(
    `id` bigint(11) NOT NULL COMMENT '评论主键ID',
    `blog_id` bigint(11) NOT NULL COMMENT '微博ID',
    `member_id` bigint(11) NOT NULL COMMENT '会员ID',
    `member_nickname` varchar(100) NOT NULL COMMENT '会员昵称',
    `member_avatar` varchar(200) NOT NULL COMMENT '会员头像',
    `comment_text` varchar(140) NOT NULL COMMENT '评论内容',
    `comment_imgs` varchar(150) NOT NULL COMMENT '评论图片',
    `at` varchar(150) NOT NULL DEFAULT '' COMMENT '@了谁，下划线分割', 
    `like` bigint(11) NOT NULL COMMENT '点赞数',
    `parent_id` bigint(11) NOT NULL DEFAULT 0 COMMENT '评论父ID，为0则是主评论',
    `status` tinyint(1) DEFAULT 1 COMMENT '状态(0：无效 1：有效)',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '微博点赞表';

DROP TABLE IF EXISTS `wb_topic`;
CREATE TABLE `wb_topic`(
    `id` bigint(11) NOT NULL COMMENT '主题主键ID',
    `title` varchar(100) NOT NULL COMMENT '主题标题',
    `watch` int(12) NOT NULL COMMENT '阅读数',
    `count` bigint(11) NOT NULL COMMENT '讨论数',
    `status` tinyint(1) DEFAULT 1 COMMENT '状态(0：无效 1：有效)',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '微博主题表';

DROP TABLE IF EXISTS `wb_blog_like`;
CREATE TABLE `wb_blog_like`(
    `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `blog_id` bigint(11) NOT NULL COMMENT '微博ID',
    `member_id` bigint(11) NOT NULL COMMENT '会员ID',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_member_id` (`member_id`)
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '微博点赞表';

DROP TABLE IF EXISTS `wb_comment_like`;
CREATE TABLE `wb_comment_like`(
    `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `comment_id` bigint(11) NOT NULL COMMENT '评论ID',
    `member_id` bigint(11) NOT NULL COMMENT '会员ID',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_member_id` (`member_id`)
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '评论点赞表';


docker run -d --name kafka -p 9092:9092 --link zookeeper --env KAFKA_ZOOKEEPER_CONNECT=121.36.9.198:2181/kafka --env KAFKA_ADVERTISED_HOST_NAME=121.36.9.198 --env KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://121.36.9.198:9092 --env KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 --env KAFKA_ADVERTISED_PORT=9092  wurstmeister/kafka

————————————————
版权声明：本文为CSDN博主「思远：」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_38080370/article/details/103548679