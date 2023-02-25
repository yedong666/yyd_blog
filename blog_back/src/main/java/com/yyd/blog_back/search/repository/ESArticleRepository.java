package com.yyd.blog_back.search.repository;

import com.yyd.blog_back.dto.ArticleSearchDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;


@Component
public interface ESArticleRepository extends ElasticsearchRepository<ArticleSearchDto,String> {

}
