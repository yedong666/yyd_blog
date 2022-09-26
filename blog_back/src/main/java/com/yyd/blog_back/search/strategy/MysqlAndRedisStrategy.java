package com.yyd.blog_back.search.strategy;

import com.yyd.blog_back.common.emum.SortWayEnum;
import com.yyd.blog_back.entity.Article;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service("MysqlAndRedisStrategy")
public class MysqlAndRedisStrategy extends MySearchStrategy {

    @Override
    public List<Article> searchArticle(String keywords, Comparator<Article> comparator) {
        System.out.println("MysqlAndRedisStrategy ********** 关键词: " + keywords + "**********搜索文章");
        return null;
    }
}
