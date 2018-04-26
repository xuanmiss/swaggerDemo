package com.miss.swagger_demo.controller;

import com.miss.swagger_demo.annotation.RestWrapper;
import com.miss.swagger_demo.entity.User;
import com.miss.swagger_demo.entity.UserOptLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/19
 */
@Api(description = "测试Restful Api doc")
@RestController
@RequestMapping("/api")
public class SomeRestController {

    @ApiOperation(value = "hello测试接口",notes = "miss的第一个测试接口")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "int")
    @GetMapping("/hello")
    @RestWrapper
    public String hello(@RequestParam(value = "id")int id)
    {
        return "hello~~\nid为："+id+"的测试";
    }
    @ApiOperation(value = "第二个测试接口",notes = "miss的第二个测试接口")
    @ApiImplicitParam(name = "user",value = "用户信息",required = true,dataType = "User")
    @PostMapping("/addUser")
    @RestWrapper
    public User addUser(@RequestBody User user)
    {
        return user;
    }

    @ApiOperation(value = "获取操作记录",notes = "获取所有操作记录的接口")
    @ApiImplicitParam(name = "userOptLog",value = "操作记录的条件",dataType = "UserOptLog")
    @PostMapping("/getUserOptLog")
    @RestWrapper
    public UserOptLog getUserOptLogs(@RequestBody UserOptLog userOptLog)
    {
        return userOptLog;
    }
}
