package com.yyd.blog_back.search.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.yyd.blog_back.common.emum.SearchModuleEnum;
import com.yyd.blog_back.dto.ArticleSearchDto;
import com.yyd.blog_back.search.SearchService;
import com.yyd.blog_back.search.repository.ESArticleRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchByES implements SearchService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ESArticleRepository esArticleRepository;

    @Override
    public Object search(String keyword){


        /**
         *  构造搜索条件
         */
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 根据关键词搜索文章标题或内容
        boolQueryBuilder.must(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("articleTitle", keyword))
                        .should(QueryBuilders.matchQuery("articleContent", keyword)));
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);


        /**
         * 关键词高亮显示
         */
        HighlightBuilder.Field titleField = new HighlightBuilder.Field("articleTitle");
        titleField.preTags("<span style='color:#f47466'>");
        titleField.postTags("</span>");
        HighlightBuilder.Field contentField = new HighlightBuilder.Field("articleContent");
        contentField.preTags("<span style='color:#f47466'>");
        contentField.postTags("</span>");
        contentField.fragmentSize(200);
        nativeSearchQueryBuilder.withHighlightFields(titleField, contentField);


        /**
         * 搜索
         */


      try {
          SearchHits<ArticleSearchDto> articleSearchDtoList = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(), ArticleSearchDto.class);

          return articleSearchDtoList.getSearchHits().stream().map(hit -> {
              ArticleSearchDto article = hit.getContent();
              // 获取文章标题高亮数据
              List<String> titleHighLightList = hit.getHighlightFields().get("articleTitle");
              if (CollectionUtils.isNotEmpty(titleHighLightList)) {
                  // 替换标题数据
                  article.setArticleTitle(titleHighLightList.get(0));
              }
              // 获取文章内容高亮数据
              List<String> contentHighLightList = hit.getHighlightFields().get("articleContent");
              if (CollectionUtils.isNotEmpty(contentHighLightList)) {
                  // 替换内容数据
                  article.setArticleContent(contentHighLightList.get(contentHighLightList.size() - 1));
              }
              return article;
          }).collect(Collectors.toList());
      }catch (Exception e){
          System.out.println(e);
      }

        return new ArrayList<>();

    }

    public boolean initData(){
        ArticleSearchDto articleSearchDto = ArticleSearchDto.builder().
                articleContent("文章内容").articleTitle("文章标题").id(1).isView(true).build();
        esArticleRepository.save(articleSearchDto);

        return true;
    }

    public boolean initData(List objects){

        objects.stream().forEach(obj->elasticsearchRestTemplate.save(obj));

        return true;
    }


}
