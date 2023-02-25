package com.yyd.blog_back.service;

import com.yyd.blog_back.entity.UserRole;
import com.yyd.blog_back.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleMapper userRolesMapper;

    /**
     * 查询用户权限
     */
    public List<UserRole> findUserRoles(String userRolesId){
        String[] roleIds = userRolesId.split(",");
        List<Integer> list = Arrays.stream(roleIds).map(Integer::valueOf).collect(Collectors.toList());
        List<UserRole> userRoleList = userRolesMapper.selectBatchIds(list);
        return userRoleList;
    }
}
