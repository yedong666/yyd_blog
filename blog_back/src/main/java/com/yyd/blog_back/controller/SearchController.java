package com.yyd.blog_back.controller;


import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.search.impl.SearchByES;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private SearchByES searchByES;

    @RequestMapping("searchArticle")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result searchArticle(@Param("keyword") String keyword, Integer sortWay, Integer resourceType){
        return Result.suc(searchByES.search(keyword, sortWay, resourceType));
    }
}
