package com.coca.service;


import com.coca.mapper.TUserMapper;
import com.coca.model.TUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService {

    @Resource
    private TUserMapper tUserMapper;
    public TUser findUserById(Integer id){
        TUser tuser = new TUser();
        tuser=tUserMapper.selectByPrimaryKey(id);
        return tuser;
    }
}