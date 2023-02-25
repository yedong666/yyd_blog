package com.yyd.blog_back.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyd.blog_back.common.util.DateUtil;
import com.yyd.blog_back.dto.ControlRecordOverDto;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.entity.ControlRecord;
import com.yyd.blog_back.mapper.ArticleMapper;
import com.yyd.blog_back.mapper.ControlRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ControlRecordService extends ServiceImpl<ControlRecordMapper, ControlRecord> {
    @Autowired
    private ControlRecordMapper controlRecordMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ArticleService articleService;

    private String articleIdsKey = "articleIds";
    private String controlRecordsKey = "controlRecords";

    /**
     * 批量保存数据
     */
    public boolean saveControlRecords(List<ControlRecord> controlRecordList) {
        return super.saveBatch(controlRecordList);
    }

    /**
     * 删除表中每个用户的排序在 count 之后的操作记录（按操作时间排序）
     */
    public boolean deleteControlRecords(Integer count) {
        //获取有操作记录数溢出的所有用户id
        List<ControlRecordOverDto> msgs = controlRecordMapper.getControlRecordNumOverMsg(count);

        for (ControlRecordOverDto msg : msgs) {
            //获取用户溢出记录id
            List<Integer> ids = controlRecordMapper
                    .selectList(new QueryWrapper<ControlRecord>().select("id").eq("userId", msg.getUserId())
                            .orderByAsc("createTime").last("limit " + (msg.getCount() - count))).stream().map(ControlRecord::getId).collect(Collectors.toList());
            //批量删除
            super.removeBatchByIds(ids);
        }

        return true;
    }

    /**
     * 删除日期在createTime之前的操作记录
     */
    public boolean deleteControlRecords(String creatTime) {
        //TODO
        return true;
    }

    public List<ControlRecord> getControlRecordsByUserId(Integer userId) {
        return controlRecordMapper.selectList(new QueryWrapper<ControlRecord>().eq("userId", userId));
    }

    //根据操作记录(点赞、取消点赞、浏览)，更新文章相关数据
    public boolean updateArticleDataByControlRecord(){
        Long count = redisTemplate.opsForSet().size(articleIdsKey);
        if (count != null && count == 0){
            return true;
        }

        //获取之前所有被操作过的文章id
        List<Integer> articleIds = Objects.requireNonNull(redisTemplate.opsForSet().pop(articleIdsKey, count))
                .stream().map(item->(Integer)item).collect(Collectors.toList());
        //获取之前所有操作记录
        List<ControlRecord> controlRecords = Objects.requireNonNull(redisTemplate.opsForList().range(controlRecordsKey, 0, -1))
                .stream().map(item-> JSON.parseObject((String) item, ControlRecord.class)).collect(Collectors.toList());
        //保存记录到数据库
        saveControlRecords(controlRecords);
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

    public boolean clickLike(Integer userId, Integer articleId) {
        ControlRecord controlRecord = ControlRecord.builder().userId(userId)
                .articleId(articleId).controlType("clickLike").controlTime(DateUtil.getTime()).build();
        addControlRecord(controlRecord);
        return true;
    }

    public boolean cancelLike(Integer userId, Integer articleId) {
        ControlRecord controlRecord = ControlRecord.builder().userId(userId)
                .articleId(articleId).controlType("cancelLike").controlTime(DateUtil.getTime()).build();
        addControlRecord(controlRecord);
        return true;
    }

    public boolean readArticle(Integer userId, Integer articleId){
        ControlRecord controlRecord = ControlRecord.builder().userId(userId)
                .articleId(articleId).controlType("readArticle").controlTime(DateUtil.getTime()).build();
        addControlRecord(controlRecord);
        return true;
    }




}
