package com.example.demo.service.group.impl;/**
 * Created by Administrator on 2018/4/7.
 */

import com.example.demo.entity.User;
import com.example.demo.mapper.two.TwoUserMapper;
import com.example.demo.service.group.JTAGroupUserService;
import com.example.demo.service.one.OneUserService;
import com.example.demo.service.two.TwoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 码农的一天
 * Jack.an
 */
@Transactional
@Service
public class JTAGroupUserServiceImpl implements JTAGroupUserService {

    @Autowired
    private OneUserService oneUserService;

    @Autowired
    private TwoUserService twoUserService;

    @Override
    public void insertUser() {
        User user=new User();
        user.setId(6);
        user.setUserName("jack1");
        user.setPassword("456789");
        oneUserService.insertOneUser(user);
        twoUserService.inserTwoUser(user);
    }
}
