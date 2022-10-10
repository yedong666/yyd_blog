package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.common.util.Message;
import com.yyd.blog_back.entity.Tag;
import com.yyd.blog_back.mapper.TagMapper;
import com.yyd.blog_back.vo.TagsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    public List<TagsVo> getTagsByGroup(){
        List<TagsVo> tagsVoList = new ArrayList<>();
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        List<Tag> tagsOfStudy =  tagMapper.selectList(queryWrapper.eq("classify", Message.STUDYGROUP));
        queryWrapper.clear();
        List<Tag> tagsOfLife = tagMapper.selectList(queryWrapper.eq("classify", Message.LIFEGROUP));
        queryWrapper.clear();
        List<Tag> tagsOfShare = tagMapper.selectList(queryWrapper.eq("classify", Message.SHAREGROUP));

        tagsVoList.add(new TagsVo(Message.STUDYGROUP, tagsOfStudy));
        tagsVoList.add(new TagsVo(Message.LIFEGROUP, tagsOfLife));
        tagsVoList.add(new TagsVo(Message.SHAREGROUP, tagsOfShare));
        return tagsVoList;
    }
}
