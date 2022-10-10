package com.yyd.blog_back.common.emum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 搜索内容排序方式枚举
 */
@Getter
@AllArgsConstructor
public enum SortWayEnum {
    SORT_BY_DATE(1, "按日期排序"),
    SORT_BY_HOT(2, "按热度排序"),
    SORT_BY_VIEW(3, "按浏览量排序");
    private final Integer id;
    private final String des;
}
