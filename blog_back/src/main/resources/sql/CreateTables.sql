drop table  if exists yyd_blog.user;
CREATE TABLE `yyd_blog`.`user` (
                                   `id` INT NOT NULL AUTO_INCREMENT,
                                   `account` VARCHAR(12) NULL,
                                   `password` VARCHAR(12) NULL,
                                   `nickname` VARCHAR(12) NULL,
                                   `phoneNumber` VARCHAR(11) NULL,
                                   `email` VARCHAR(20) NULL,
                                   `status` INT NULL,
                                   PRIMARY KEY (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


