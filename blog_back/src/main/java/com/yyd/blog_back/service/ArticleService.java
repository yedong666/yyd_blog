package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyd.blog_back.common.BaseImpl.EntityAccessService;
import com.yyd.blog_back.common.util.DateUtil;
import com.yyd.blog_back.dto.ArticleHotDto;
import com.yyd.blog_back.dto.ArticleNewDto;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.entity.ControlRecord;
import com.yyd.blog_back.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("ArticleService")
public class ArticleService extends ServiceImpl<ArticleMapper, Article> implements EntityAccessService {
    @Autowired
    private ArticleMapper articleMapper;

    @Value("${project.page.size}")
    private Integer pageSize;

    /**
     * 查询所有文章
     *
     * @return List<Article>
     */
    public List<Article> getAllArticles() {
        return articleMapper.selectList(null);
    }

    /**
     * 根据作者查询文章
     *
     * @return List<Article>
     */
    public List<Article> getArticlesByAuthor(String arthor) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("author", arthor);
        return articleMapper.selectList(queryWrapper);
    }

    public Article getArticleById(Integer id) {
        return articleMapper.selectById(id);
    }

    /**
     * 添加文章
     *
     * @return boolean
     */
    public boolean addArticle(Article article) {
        try {
            article.setCreateTime(DateUtil.getTime());
            articleMapper.insert(article);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Long getArticlesCount() {
        return articleMapper.selectCount(new QueryWrapper<>(null));
    }

    /**
     * 分页查询
     *
     * @return
     */
    public List<Article> getArticlesByPage(int pageNum) {
        return articleMapper.selectPage(new Page<>(pageNum, this.pageSize), new QueryWrapper<>()).getRecords();
    }

    public List<ArticleHotDto> getHotArticles() {

        return articleMapper.getArticlesOrderByHot(10);
    }

    public List<ArticleNewDto> getNewArticles() {
        return articleMapper.selectList(new QueryWrapper<Article>().select("id", "title", "createTime").orderByDesc("createTime").last("limit 10"))
                .stream().map(ArticleNewDto::new).collect(Collectors.toList());
    }

    @Override
    public Long getEntityDataCount() {
        return getArticlesCount();
    }

    @Override
    public List<Article> getEntityDataByIds(List<Integer> ids) {
        if(ids == null){
            return getAllArticles();
        }
        return articleMapper.selectBatchIds(ids);

    }

    /**
     * 获取id集
     * @return
     */
    public Set<Integer> getIdSet(){
        return articleMapper.selectList(new QueryWrapper<Article>().select("id")).stream().map(Article::getId).collect(Collectors.toSet());
    }

}
