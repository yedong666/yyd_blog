package com.yyd.blog_back.search.comparator;

import com.yyd.blog_back.common.emum.SortWayEnum;
import com.yyd.blog_back.entity.Article;

import java.util.Comparator;

public class ComparatorForArticle extends ComparatorClasses{
    private static final Comparator<Article> articleComparatorByDate = Comparator.comparing(Article::getCreateTime);
    private static final Comparator<Article> articleComparatorByHot = (a, b)-> a.getHot() > b.getHot() ? 1 : -1;
    private static final Comparator<Article> articleComparatorByView = (a, b)->a.getNumberOfView() > b.getNumberOfView() ? 1 : -1;
    static{
        comparatorClassMap.put(SortWayEnum.SORT_BY_DATE.getId(), articleComparatorByDate);
        comparatorClassMap.put(SortWayEnum.SORT_BY_HOT.getId(), articleComparatorByHot);
        comparatorClassMap.put(SortWayEnum.SORT_BY_VIEW.getId(), articleComparatorByView);
    }

    @Override
    public Comparator<Article> getComparator(Integer sortWayId) {
        return comparatorClassMap.get(sortWayId);
    }
}
