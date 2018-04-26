package com.miss.swagger_demo.service;

import com.miss.swagger_demo.annotation.UserOptLogAnnotation;
import com.miss.swagger_demo.dao.UserMapper;
import com.miss.swagger_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/19
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @UserOptLogAnnotation(content = "添加用户")
    public void addUser(User user)
    {
        userMapper.addUser(user);
    }

    @UserOptLogAnnotation(content = "获取用户列表")
    public List<User> getUsers()
    {
        return userMapper.getUsers();
    }

    @UserOptLogAnnotation(content = "获取用户详情")
    public User getUserByName(String name)
    {
        return userMapper.getUserByName(name);
    }
}
