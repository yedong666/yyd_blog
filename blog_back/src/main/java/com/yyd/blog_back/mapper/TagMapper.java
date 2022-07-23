package com.yyd.blog_back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyd.blog_back.entity.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TagMapper extends BaseMapper<Tag> {
    int create(Tag tag);
    Tag getTagById(@Param("id") Integer id);
}
