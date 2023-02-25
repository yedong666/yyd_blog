package com.yyd.blog_back.vo;

import com.yyd.blog_back.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class TagVo implements Serializable {
    private String classify;
    private List<Tag> tagList;
}
