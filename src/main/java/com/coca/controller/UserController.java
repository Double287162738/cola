package com.coca.controller;


import com.coca.model.TUser;
import com.coca.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("findUserById.do")
    @ResponseBody

    public TUser findUserById(Integer id){
        TUser tuser = new TUser();
        tuser=userService.findUserById(id);
        return tuser;
    }
}