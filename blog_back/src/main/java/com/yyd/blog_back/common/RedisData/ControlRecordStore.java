package com.yyd.blog_back.common.RedisData;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.entity.ControlRecord;
import com.yyd.blog_back.mapper.ArticleMapper;
import com.yyd.blog_back.service.ArticleService;
import com.yyd.blog_back.service.ControlRecordService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 操作记录存储结构
 */

@Component
public class ControlRecordStore {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ControlRecordService controlRecordService;

    @Autowired
    private ArticleMapper articleMapper;

    private String articleIdsKey = "articleIds";
    private String controlRecordsKey = "controlRecords";

    public boolean saveToMysql(){
        Long count = redisTemplate.opsForSet().size(articleIdsKey);
        if (count != null && count == 0){
            return true;
        }
        List<Integer> articleIds = Objects.requireNonNull(redisTemplate.opsForSet().pop(articleIdsKey, count))
                        .stream().map(item->(Integer)item).collect(Collectors.toList());
        
        List<ControlRecord> controlRecords = Objects.requireNonNull(redisTemplate.opsForList().range(controlRecordsKey, 0, -1))
                        .stream().map(item->JSON.parseObject((String) item, ControlRecord.class)).collect(Collectors.toList());
        //保存记录到数据库
        controlRecordService.saveControlRecords(controlRecords);
        redisTemplate.delete(controlRecordsKey);

        HashMap<Integer,Article> articles = new HashMap<>();
        articleMapper.selectBatchIds(articleIds).stream().forEach(item->articles.put(item.getId(), item));

        List<Article> newArticleList =  new ArrayList<>();

        for(ControlRecord controlRecord : controlRecords){
            Article article = articles.get(controlRecord.getArticleId());
            switch (controlRecord.getControlType()){
                case "clickLike": article.setNumberOfLike(article.getNumberOfLike() + 1); break;
                case "cancelLike": article.setNumberOfLike(article.getNumberOfLike() - 1); break;
                case "readArticle": article.setNumberOfView(article.getNumberOfView() + 1); break;
            }
            articles.put(controlRecord.getArticleId(), article);
        }

        for(Integer key : articles.keySet()){
            newArticleList.add(articles.get(key));
        }

        for(Article article : newArticleList){
            System.out.println(article.getNumberOfLike());
        }
        articleService.updateBatchById(newArticleList);

        return true;
    }

    public boolean addControlRecord(ControlRecord controlRecord){
        redisTemplate.opsForSet().add(articleIdsKey, controlRecord.getArticleId());
        redisTemplate.opsForList().leftPush(controlRecordsKey, controlRecord.toString());
        return true;
    }




}
