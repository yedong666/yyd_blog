package com.yyd.blog_back.search.comparator;

import com.yyd.blog_back.common.emum.SortWayEnum;
import com.yyd.blog_back.dto.ArticleSearchDto;
import com.yyd.blog_back.entity.Article;

import java.util.Comparator;

public class ComparatorForArticle extends ComparatorClasses{
    private static final Comparator<ArticleSearchDto> articleComparatorByDate = Comparator.comparing(ArticleSearchDto::getCreateTime);
    private static final Comparator<ArticleSearchDto> articleComparatorByHot = Comparator.comparing(ArticleSearchDto::getHot);
    private static final Comparator<ArticleSearchDto> articleComparatorByView = Comparator.comparing(ArticleSearchDto::getNumberOfView);
    static {
        comparatorClassMap.put(SortWayEnum.SORT_BY_DATE.getId(), articleComparatorByDate);
        comparatorClassMap.put(SortWayEnum.SORT_BY_HOT.getId(), articleComparatorByHot);
        comparatorClassMap.put(SortWayEnum.SORT_BY_VIEW.getId(), articleComparatorByView);
    }

    @Override
    public Comparator getComparator(Integer sortWayId) {
        return comparatorClassMap.get(sortWayId);
    }
}
