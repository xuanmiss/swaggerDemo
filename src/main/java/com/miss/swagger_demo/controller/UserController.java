package com.miss.swagger_demo.controller;

import com.miss.swagger_demo.annotation.RestWrapper;
import com.miss.swagger_demo.entity.User;
import com.miss.swagger_demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/19
 */
@Api(description = "用户操作接口")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户",notes = "添加用户信息")
    @ApiImplicitParam(name = "user",value = "用户实体",required = true,dataType = "User")
    @PostMapping("/addUser")
    @RestWrapper(message = "添加用户")
    public User addUser(@RequestBody User user)
    {
        userService.addUser(user);
        return userService.getUserByName(user.getName());
    }

    @ApiOperation(value = "获取用户",notes = "获取用户详情")
    @ApiImplicitParam(name = "name",value = "用户名",required = true,dataType = "String")
    @GetMapping("/getUserByName")
    @RestWrapper(message = "获取用户详情")
    public User getUserByName(@RequestParam(value = "name")String name)
    {
        return userService.getUserByName(name);
    }

    @ApiOperation(value = "用户列表",notes = "获取用户列表")
    @GetMapping("/getUsers")
    @RestWrapper(message = "用户列表获取成功")
    public List<User> getUsers()
    {
        return userService.getUsers();
    }

}
