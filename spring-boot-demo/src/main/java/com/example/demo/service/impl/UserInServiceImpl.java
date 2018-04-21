package com.example.demo.service.impl;/**
 * Created by Administrator on 2018/3/13.
 */

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserInService;
import com.example.demo.service.UserOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 码农的一天
 * Jack.an
 */
@Service
public class UserInServiceImpl implements UserInService
{
   /* @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserOutService userOutService;*/


    @Override
    @Transactional
    public void inUser() {
      /*  userMapper.inUser();
        //测试事物的传播属性

            userOutService.outUser();
        throw new RuntimeException("出错了");
*/


    }
}
