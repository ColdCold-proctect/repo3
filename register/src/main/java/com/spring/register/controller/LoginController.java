package com.spring.register.controller;

import com.spring.register.pojo.User;
import com.spring.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;


    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password){
        User user=userService.checkUser(username,password);
        if(user!=null){
            return "true";
        }else{
            return "false";
        }
    }
}
