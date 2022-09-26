package com.yyd.blog_back.test;

import com.yyd.blog_back.entity.UserRole;
import com.yyd.blog_back.mapper.UserRolesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class RoleTest {

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Test
    public void test(){
        String[] strings = ("1,2,3").split(",");
        List<Integer> stringList = Arrays.stream(strings).map(Integer::valueOf).collect(Collectors.toList());
        List<UserRole> userRoleList = userRolesMapper.selectBatchIds(stringList);
        userRoleList.stream().forEach(role-> System.out.println(role.getName()));
    }
}
