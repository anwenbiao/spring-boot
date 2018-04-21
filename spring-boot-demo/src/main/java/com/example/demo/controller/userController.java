package com.example.demo.controller;/**
 * Created by Administrator on 2017/12/10.
 */

import com.example.demo.entity.User;
import com.example.demo.service.UserInService;
import com.example.demo.service.UserSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 码农的一天
 * Jack.an
 */
@RestController
public class userController {

    @Autowired
    private UserSercvice userSercvice;
    @Autowired
    private UserInService userInService;

    @RequestMapping("index1")
    public String getStr(String name){
        return  "Jack ---"+System.currentTimeMillis();
    }

    @RequestMapping("getUser/{id}")
    public User getUser(@PathVariable  int id, HttpServletRequest request){

        request.getDispatcherType();
        return userSercvice.getUser(id);
    }

    @RequestMapping("getAllUser")
    public List<User> getAllUser(){
        return userSercvice.getAllUser();
    }

    @RequestMapping("inUser")
    public int inUser(){


            userInService.inUser();

        return 1;
    }

}
