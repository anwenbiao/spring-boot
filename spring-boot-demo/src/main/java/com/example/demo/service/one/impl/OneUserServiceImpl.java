package com.example.demo.service.one.impl;/**
 * Created by Administrator on 2018/4/7.
 */

import com.example.demo.entity.User;
import com.example.demo.mapper.one.OneUserMapper;
import com.example.demo.service.one.OneUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 码农的一天
 * Jack.an
 */
@Service
public class OneUserServiceImpl implements OneUserService {

    @Autowired
    private OneUserMapper oneUserMapper;
    @Override
    public void insertOneUser(User user) {
        oneUserMapper.insertone(user);
    }
}
