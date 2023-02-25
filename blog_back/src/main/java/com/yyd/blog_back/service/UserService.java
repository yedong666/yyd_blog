package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.common.util.CreateAccountUtil;
import com.yyd.blog_back.config.JwtConfig;
import com.yyd.blog_back.dto.ChatUserDto;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.entity.UserData;
import com.yyd.blog_back.mapper.UserDataMapper;
import com.yyd.blog_back.mapper.UserMapper;
import com.yyd.blog_back.vo.UserDataVo;
import com.yyd.blog_back.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUsers(){
        return userMapper.selectList(null);
    }

    public List<UserVo> getUserVoList(){
        List<UserVo> userVoList = new ArrayList<>();
        getAllUsers().stream().forEach(user -> {
            userVoList.add(new UserVo(user, redisTemplate.opsForValue().get(JwtConfig.REDIS_TOKEN_KEY_PREFIX + user.getAccount()) != null));

        });
        return userVoList;
    }

    public User login(String account, String password, String temp){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        User user = userMapper.selectOne(queryWrapper);
        if (!user.getPassword().equals(password)){
            return null;
        }
        return user;
    }

    public User register(User newUser){
        newUser.setAccount(CreateAccountUtil.createAccount());
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        newUser.setStatus(0);
        newUser.setRolesId("2,3");
        userMapper.insert(newUser);
        return newUser;
    }

    public User getUserById(Integer id){
        return userMapper.selectById(id);
    }

    /**
     * 根据账号查找用户
     * @param account
     * @return
     */
    public User getUserByAccount(String account){
        return userMapper.selectOne(this.getQueryWrapper("account", account));
    }


    public QueryWrapper<User> getQueryWrapper(String name, String value){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return queryWrapper.eq(name, value);
    }

    public Boolean updateUser(UserDataVo userDataVo){
        User user = userMapper.selectById(userDataVo.getId());
        user.setNickname(userDataVo.getNickname());
        user.setStatus(userDataVo.getStatus());
        user.setPhoneNumber(userDataVo.getPhoneNumber());
        user.setEmail(userDataVo.getEmail());

        userMapper.updateById(user);

        UserData userData = userDataMapper.selectById(user.getUserDataId());
        userData.setAvatar(userDataVo.getAvatar());
        userData.setDes(userDataVo.getDes());
        userData.setGender(userDataVo.getGender());
        userData.setBirthdate(userDataVo.getBirthdate());

        StringBuilder tags = new StringBuilder();
        for(String tag : userDataVo.getTags()){
            tags.append(tag).append(",");
        }
        userData.setTags(tags.toString());
        userDataMapper.updateById(userData);
        return true;
    }

    public ChatUserDto buildChatUserDto(Integer userId){
        User user = userMapper.selectById(userId);
        ChatUserDto chatUserDto = new ChatUserDto();
        if(!Objects.isNull(user)){
            UserData userData = userDataMapper.selectById(user.getUserDataId());
            chatUserDto.setUserId(userId);
            chatUserDto.setNickName(user.getNickname());
            chatUserDto.setAvatarUrl(userData.getAvatar());
            return chatUserDto;
        }
        return null;
    }
}
