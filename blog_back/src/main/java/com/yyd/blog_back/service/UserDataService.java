package com.yyd.blog_back.service;

import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.entity.UserData;
import com.yyd.blog_back.mapper.UserDataMapper;
import com.yyd.blog_back.vo.UserDataVo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {
    @Autowired
    private UserDataMapper userDataMapper;

    public List<UserData> getBatchIds(List<Integer> ids){
        if(ids == null){
            return null;
        }
        return userDataMapper.selectBatchIds(ids);
    }

    public UserData getUserDataById(Integer id){
        return userDataMapper.selectById(id);
    }

}
