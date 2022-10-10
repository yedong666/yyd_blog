package com.yyd.blog_back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyd.blog_back.dto.ArticleHotDto;
import com.yyd.blog_back.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper extends BaseMapper<Article>{
    List<ArticleHotDto> getArticlesOrderByHot(int num);
}
