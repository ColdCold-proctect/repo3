package com.spring.register.controller;

import com.spring.register.pojo.User;
import com.spring.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "注册接口")
@Controller
public class RegisterController {
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String index() {
        return "register";
    }

    @ApiOperation(value = "注册登录功能", notes = "用户将信息提交后注册")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱", paramType = "query"),
            @ApiImplicitParam(name = "birthday", value = "生日", paramType = "query"),
            @ApiImplicitParam(name = "sex", value = "性别", paramType = "query"),
            @ApiImplicitParam(name = "grade", value = "年级", paramType = "query"),
            @ApiImplicitParam(name = "interest", value = "兴趣", paramType = "query"),
            @ApiImplicitParam(name = "description", value = "自我介绍", paramType = "query"),
    })
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public Map<String, Object> register(User user) {
        Integer result = userService.registerAll(user);
        Map<String, Object> map = new HashMap<>();
        if (result >= 1) {
            map.put("status", "1");
            map.put("data", "success");
            map.put("error", null);
        }
        return map;
    }

    @PostMapping(value = "/register2", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> register2(@RequestBody User user) {
        Integer result = userService.registerAll(user);
        Map<String, Object> map = new HashMap<>();
        if (result >= 1) {
            map.put("status", "1");
            map.put("data", "success");
            map.put("error", null);
        }
        return map;
    }

}
