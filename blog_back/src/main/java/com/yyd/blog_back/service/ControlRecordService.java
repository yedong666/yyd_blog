package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyd.blog_back.dto.ControlRecordOverDto;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.entity.ControlRecord;
import com.yyd.blog_back.mapper.ArticleMapper;
import com.yyd.blog_back.mapper.ControlRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ControlRecordService extends ServiceImpl<ControlRecordMapper, ControlRecord> {
    @Autowired
    private ControlRecordMapper controlRecordMapper;

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
     * 删除日期在creatTime之前的操作记录
     */
    public boolean deleteControlRecords(String creatTime) {
        //TODO
        return true;
    }

    public List<ControlRecord> getControlRecordsByUserId(Integer userId) {
        return controlRecordMapper.selectList(new QueryWrapper<ControlRecord>().eq("userId", userId));
    }


}
