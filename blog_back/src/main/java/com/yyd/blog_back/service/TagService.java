package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.common.constValue.ResponseMsgVal;
import com.yyd.blog_back.entity.Tag;
import com.yyd.blog_back.mapper.TagMapper;
import com.yyd.blog_back.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    public List<TagVo> getTagsByGroup(){
        List<TagVo> tagsVoList = new ArrayList<>();
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        List<Tag> tagsOfStudy =  tagMapper.selectList(queryWrapper.eq("classify", ResponseMsgVal.STUDYGROUP));
        queryWrapper.clear();
        List<Tag> tagsOfLife = tagMapper.selectList(queryWrapper.eq("classify", ResponseMsgVal.LIFEGROUP));
        queryWrapper.clear();
        List<Tag> tagsOfShare = tagMapper.selectList(queryWrapper.eq("classify", ResponseMsgVal.SHAREGROUP));

        tagsVoList.add(new TagVo(ResponseMsgVal.STUDYGROUP, tagsOfStudy));
        tagsVoList.add(new TagVo(ResponseMsgVal.LIFEGROUP, tagsOfLife));
        tagsVoList.add(new TagVo(ResponseMsgVal.SHAREGROUP, tagsOfShare));
        return tagsVoList;
    }

    public List<Tag> getAllTags(){
        return tagMapper.selectList(null);
    }
 }
