package com.yyd.blog_back.contoller;

import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("getTags")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getTags(){
        return Result.success(tagService.getTagsByGroup());
    }
}
