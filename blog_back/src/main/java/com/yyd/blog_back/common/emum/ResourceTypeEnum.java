package com.yyd.blog_back.common.emum;

import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.search.comparator.ComparatorClasses;
import com.yyd.blog_back.search.comparator.ComparatorForArticle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


/**
 * 站内资源枚举
 */
@Getter
@AllArgsConstructor
public enum ResourceTypeEnum {
    ARTICLE(1, "Article", "文章资源", new ComparatorForArticle(), new Article());
    private final Integer id;
    private final String name;
    private final String desc;
    private final ComparatorClasses comparatorClasses;
    private final Article article;
    private static final Logger logger = LoggerFactory.getLogger(ResourceTypeEnum.class);

    public static ResourceTypeEnum getResourceTypeByName(String name){
        for(ResourceTypeEnum resourceTypeEnum : ResourceTypeEnum.values()){
            if(resourceTypeEnum.getName().equals(name)){
                return resourceTypeEnum;
            }
        }
        logger.error("不存在该资源类型", name);
        return null;
    }
}



