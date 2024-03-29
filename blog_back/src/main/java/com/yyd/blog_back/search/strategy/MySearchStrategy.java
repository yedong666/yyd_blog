package com.yyd.blog_back.search.strategy;

import com.yyd.blog_back.common.BaseObj.BaseEntityObject;
import com.yyd.blog_back.common.BaseObj.BaseSearchObject;
import com.yyd.blog_back.common.emum.ResourceTypeEnum;
import com.yyd.blog_back.common.emum.SortWayEnum;
import com.yyd.blog_back.entity.Article;

import java.util.Comparator;
import java.util.List;

/**
 * 策略接口
 */
public abstract class MySearchStrategy {
    /**
     * @param keywords 关键词序列
     * @param sortWayEnum 排序方式
     * @param resourceTypeEnum 资源类型
     * @return 返回内容
     */
    public abstract List<Object> search(String keywords, SortWayEnum sortWayEnum, ResourceTypeEnum resourceTypeEnum);

}
