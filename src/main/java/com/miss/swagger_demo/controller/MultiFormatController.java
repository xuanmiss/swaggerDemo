package com.miss.swagger_demo.controller;

import com.miss.swagger_demo.annotation.RestWrapper;
import com.miss.swagger_demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/5/31
 */
@Api(description = "测试Restful Api doc")
@RestController
@RequestMapping("/api/multi")
public class MultiFormatController {

    @ApiOperation(value = "多格式传参",notes = "测试多格式传参")
    @ApiImplicitParam(name = "user",value = "用户信息",required = true,dataType = "Object")
    @PostMapping("/returnOne")
    @RestWrapper
    public Object addUser(@RequestBody Object data)
    {
        System.out.println(data.toString());
        return data;
    }
}
