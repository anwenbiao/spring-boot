package com.example.demo.service.impl;/**
 * Created by Administrator on 2017/12/10.
 */

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 码农的一天
 * Jack.an
 */
@Service
public class UserServiceImpl implements UserSercvice {

    /*@Autowired
    private UserMapper userMapper;*/

    @Override
    public User getUser(int id) {
       /* return userMapper.getUser(id);*/
       return null;
    }

    @Override
    public List<User> getAllUser() {
       /* return userMapper.getAllUser();*/
       return null;
    }
}
