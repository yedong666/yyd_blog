--创建user表
drop table if exists yyd_blog.user;
CREATE TABLE `yyd_blog`.`user`
(
    `id`          INT NOT NULL AUTO_INCREMENT,
    `account`     VARCHAR(12) NULL,
    `password`    VARCHAR(100) NULL,
    `nickname`    VARCHAR(12) NULL,
    `phoneNumber` VARCHAR(11) NULL,
    `email`       VARCHAR(20) NULL,
    `status`      INT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

--创建article表
drop table if exists yyd_blog.article;
CREATE TABLE `yyd_blog`.`article`
(
    `id`                  INT NOT NULL AUTO_INCREMENT,
    `title`               varchar(100) NULL,
    `content`             VARCHAR(1000) NULL,
    `summarize`           text NULL,
    `author`              VARCHAR(20) NULL,
    `coverImage`          varchar(100) NULL,
    `type`                varchar(30) NULL,
    `tags`                varchar(50) NULL,
    `numberOfComment`     INT NULL,
    `numberOfLike`        INT NULL,
    `numberOfView`        INT NULL,
    `isView`              tinyint(1) NULL,
    `isPublicCommentArea` tinyint(1) NULL,
    `isAllowedTurn`       tinyint(1) NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--创建tags表
drop table if exists yyd_blog.tags;
CREATE TABLE `yyd_blog`.`tags`
(
    `id`          INT NOT NULL AUTO_INCREMENT,
    `name`        varchar(20) NULL,
    `imgUrl`      varchar(50) NULL,
    `description` varchar(500) NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--创建comments表
drop table if exists yyd_blog.comments;
CREATE TABLE `yyd_blog`.`comments`
(
    `id`            INT NOT NULL AUTO_INCREMENT,
    `content`       text NULL,
    `observerId`    INT NULL,
    `articleId`     INT NULL,
    `replyId`       INT NULL,
    `date`          varchar(50) NULL,
    `numberOfLike`  int NULL,
    `numberOfReply` int NULL,
    `numberOfView`  int NULL,

    PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

drop table if exists yyd_blog.userRole;
CREATE TABLE `yyd_blog`.`userRole`
(
    `id`   INT          NOT NULL AUTO_INCREMENT,
    `name` varchar(100) not null,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `yyd_blog`.`controlRecord`
(
    `id`          INT NOT NULL AUTO_INCREMENT,
    `userId`      INT,
    `articleId`   INT,
    `controlType` varchar(20),
    `controlTime` varchar(20),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8
