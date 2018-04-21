package com.example.demo.controller;/**
 * Created by Administrator on 2018/4/7.
 */

import com.example.demo.service.group.JTAGroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 码农的一天
 * Jack.an
 */
@Controller
public class JTAGroupUserController {

    @Autowired
    private JTAGroupUserService jtaGroupUserService;

    @RequestMapping("/insertGroupUser")
    public void insertGroupUser(){
        jtaGroupUserService.insertUser();
    }
}
