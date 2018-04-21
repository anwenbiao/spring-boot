package com.example.demo.service.two.impl;/**
 * Created by Administrator on 2018/4/7.
 */

import com.example.demo.entity.User;
import com.example.demo.mapper.one.OneUserMapper;
import com.example.demo.mapper.two.TwoUserMapper;
import com.example.demo.service.one.OneUserService;
import com.example.demo.service.two.TwoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 码农的一天
 * Jack.an
 */
@Service
public class TwoUserServiceImpl implements TwoUserService {

    @Autowired
    private TwoUserMapper twoUserMapper;


    @Override
    public void inserTwoUser(User user) {
        twoUserMapper.insertTwo(user);
        int a=4/0;
    }
}
