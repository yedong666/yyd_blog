package com.yyd.blog_back.common.emum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 搜索模式枚举
 */
@Getter
@AllArgsConstructor
public enum SearchModuleEnum {

    ELASTICSEARCH(1, "ElasticSearch", "使用ElasticSearch进行搜索", "ElasticSearchStrategy"),

    MYSQL_AND_REDIS(2, "MysqlAndRedis", "使用Mysql模糊查询进行搜索", "MysqlAndRedisStrategy");

    /**
     * 状态
     */
    private final Integer id;

    private final String value;

    /**
     * 描述
     */
    private final String desc;

    /**
     * 使用策略
     */
    private final String strategyName;
}
