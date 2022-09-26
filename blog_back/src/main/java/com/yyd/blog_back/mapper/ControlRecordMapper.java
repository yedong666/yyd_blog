package com.yyd.blog_back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyd.blog_back.dto.ControlRecordOverDto;
import com.yyd.blog_back.entity.ControlRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ControlRecordMapper extends BaseMapper<ControlRecord> {

    /**
     * 获取操作记录数量超过规定范围的用户id与操作记录数
     */
    List<ControlRecordOverDto> getControlRecordNumOverMsg(Integer count);
}

