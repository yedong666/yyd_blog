create database yyd_blog;

CREATE TABLE `yyd_blog`.`user` (
                                   `id` INT NOT NULL,
                                   `account` VARCHAR(45) NULL,
                                   `password` VARCHAR(45) NULL,
                                   `nickname` VARCHAR(45) NULL,
                                   `status` INT NULL,
                                   PRIMARY KEY (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;