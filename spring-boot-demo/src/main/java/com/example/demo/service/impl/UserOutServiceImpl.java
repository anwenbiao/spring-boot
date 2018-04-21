package com.example.demo.service.impl;/**
 * Created by Administrator on 2018/3/13.
 */

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 码农的一天
 * Jack.an
 */
@Service
public class UserOutServiceImpl implements UserOutService{

    /*@Autowired
    private UserMapper userMapper;*/

    @Override
    @Transactional(propagation= Propagation.NESTED)
    public void outUser() {
       /* userMapper.outUser();*/




    }
}
