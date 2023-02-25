package com.yyd.blog_back.search.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.yyd.blog_back.common.constValue.HighlightTagVal;
import com.yyd.blog_back.dto.ArticleSearchDto;
import com.yyd.blog_back.dto.TagSearchDto;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.entity.Tag;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.entity.UserData;
import com.yyd.blog_back.mapper.UserMapper;
import com.yyd.blog_back.search.SearchService;
import com.yyd.blog_back.search.repository.ESArticleRepository;
import com.yyd.blog_back.service.ArticleService;
import com.yyd.blog_back.service.TagService;
import com.yyd.blog_back.service.UserDataService;
import com.yyd.blog_back.service.UserService;
import io.swagger.models.auth.In;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDataService userDataService;

    @Override
    public Object search(String keyword, Integer sortWay, Integer resourceType){
        Object searchResult = null;
        switch (resourceType){
            case 1:
                searchResult = searchArticle(keyword, sortWay); break;
            case 2:
                searchResult = searchTag(keyword, sortWay); break;
            case 3:
                searchResult = searchUser(keyword, sortWay); break;
            case 4:
                searchResult = searchResource(keyword, sortWay); break;

        }
        return searchResult;
    }


    public Object searchArticle(String keyword, Integer sortWay){

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
        titleField.preTags(HighlightTagVal.PRETAG_1);
        titleField.postTags(HighlightTagVal.POSTTAG);
        HighlightBuilder.Field contentField = new HighlightBuilder.Field("articleContent");
        contentField.preTags(HighlightTagVal.PRETAG_1);
        contentField.postTags(HighlightTagVal.POSTTAG);
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

    public Object searchTag(String keyword, Integer sortWay){
        /**
         *  构造搜索条件
         */
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 根据关键词搜索标签名字或描述
        boolQueryBuilder.must(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", keyword))
                .should(QueryBuilders.matchQuery("description", keyword)));
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);


        /**
         * 关键词高亮显示
         */
        HighlightBuilder.Field nameField = new HighlightBuilder.Field("name");
        nameField.preTags(HighlightTagVal.PRETAG_1);
        nameField.postTags(HighlightTagVal.POSTTAG);
        HighlightBuilder.Field descriptionField = new HighlightBuilder.Field("description");
        descriptionField.preTags(HighlightTagVal.PRETAG_1);
        descriptionField.postTags(HighlightTagVal.POSTTAG);

        //设置搜索结果上下文长度
        descriptionField.fragmentSize(200);
        nativeSearchQueryBuilder.withHighlightFields(nameField, descriptionField);


        /**
         * 搜索
         */


        try {
            SearchHits<TagSearchDto> tagSearchDtoList = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(), TagSearchDto.class);

            return tagSearchDtoList.getSearchHits().stream().map(hit -> {
                TagSearchDto tagSearchDto = hit.getContent();
                // 获取文章标题高亮数据
                List<String> nameHighLightList = hit.getHighlightFields().get("name");
                if (CollectionUtils.isNotEmpty(nameHighLightList)) {
                    // 替换标题数据
                    tagSearchDto.setName(nameHighLightList.get(0));
                }
                // 获取文章内容高亮数据
                List<String> descriptionHighLightList = hit.getHighlightFields().get("description");
                if (CollectionUtils.isNotEmpty(descriptionHighLightList)) {
                    // 替换内容数据
                    tagSearchDto.setDescription(descriptionHighLightList.get(0));
                }
                return tagSearchDto;
            }).collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e);
        }

        return new ArrayList<>();
    }

    public Object searchUser(String keyword, Integer sortWay){
        /**
         *  构造搜索条件
         */
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 根据关键词搜索标签名字或描述
        boolQueryBuilder.must(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", keyword))
                .should(QueryBuilders.matchQuery("description", keyword)));
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);


        /**
         * 关键词高亮显示
         */
        HighlightBuilder.Field nameField = new HighlightBuilder.Field("name");
        nameField.preTags(HighlightTagVal.PRETAG_1);
        nameField.postTags(HighlightTagVal.POSTTAG);
        HighlightBuilder.Field descriptionField = new HighlightBuilder.Field("description");
        descriptionField.preTags(HighlightTagVal.PRETAG_1);
        descriptionField.postTags(HighlightTagVal.POSTTAG);

        //设置搜索结果上下文长度
        descriptionField.fragmentSize(200);
        nativeSearchQueryBuilder.withHighlightFields(nameField, descriptionField);


        /**
         * 搜索
         */


        try {
            SearchHits<TagSearchDto> tagSearchDtoList = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(), TagSearchDto.class);

            return tagSearchDtoList.getSearchHits().stream().map(hit -> {
                TagSearchDto tagSearchDto = hit.getContent();
                // 获取文章标题高亮数据
                List<String> nameHighLightList = hit.getHighlightFields().get("name");
                if (CollectionUtils.isNotEmpty(nameHighLightList)) {
                    // 替换标题数据
                    tagSearchDto.setName(nameHighLightList.get(0));
                }
                // 获取文章内容高亮数据
                List<String> descriptionHighLightList = hit.getHighlightFields().get("description");
                if (CollectionUtils.isNotEmpty(descriptionHighLightList)) {
                    // 替换内容数据
                    tagSearchDto.setDescription(descriptionHighLightList.get(0));
                }
                return tagSearchDto;
            }).collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e);
        }

        return new ArrayList<>();

    }
    public Object searchResource(String keyword, Integer sortWay){
        return null;
    }


    public boolean initData(List objects){

        objects.stream().forEach(obj->elasticsearchRestTemplate.save(obj));

        return true;
    }

    public boolean initArticleData(){
        // 查询数据库数据文章
        List<Article> articleList = articleService.getAllArticles();

        List<ArticleSearchDto> articleSearchDtoList = articleList.stream().map(ArticleSearchDto::new).collect(Collectors.toList());

        return initData(articleSearchDtoList);
    }

    public boolean initTagData(){
        List<Tag> tagList = tagService.getAllTags();
        List<TagSearchDto> tagSearchDtoList = tagList.stream().map(TagSearchDto::new).collect(Collectors.toList());
        return initData(tagSearchDtoList);
    }

    public boolean initUserData(){

        List<User> userList = userService.getAllUsers();
        List<Integer> userDataIdList = userList.stream().map(User::getUserDataId).collect(Collectors.toList());
        List<UserData> userDataList = userDataService.getBatchIds(userDataIdList);


        return true;
    }





}
