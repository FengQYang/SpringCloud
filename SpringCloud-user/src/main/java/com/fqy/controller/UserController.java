package com.fqy.controller;

import com.fqy.pojo.user.UserReq;
import com.fqy.service.UserService;
import com.fqy.pojo.user.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody TbUser tbUser){
        return userService.login(tbUser);
    }


    @RequestMapping("/sendMail")
    public String sendMail(@RequestBody Map map){
        Object email = map.get("email");
        return userService.sendMail(email.toString());
    }

    @RequestMapping("/registry")
    public String registry(@RequestBody UserReq userReq){
        return userService.registry(userReq);
    }
}
