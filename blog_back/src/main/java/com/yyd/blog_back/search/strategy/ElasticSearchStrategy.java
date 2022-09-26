package com.yyd.blog_back.search.strategy;

import com.yyd.blog_back.entity.Article;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service("ElasticSearchStrategy")
public class ElasticSearchStrategy extends MySearchStrategy {

    @Override
    public List<Article> searchArticle(String keywords, Comparator<Article> comparator) {
        System.out.println("ElasticSearchStrategy **********  关键词: " + keywords + "搜索文章");
        return null;
    }
}
