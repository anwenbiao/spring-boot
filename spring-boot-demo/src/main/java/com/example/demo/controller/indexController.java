package com.example.demo.controller;/**
 * Created by Administrator on 2017/12/10.
 */

import com.example.demo.entity.User;
import com.example.demo.service.UserSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 码农的一天
 * Jack.an
 */
@Controller
public class indexController {

    @Autowired
    private UserSercvice userSercvice;

    @RequestMapping("/view")
    public String index(){
        return "index";
    }

    @RequestMapping("/free")
    public String free(ModelMap modelMap){
        User user=userSercvice.getUser(2);
        modelMap.put("user",user);
        return "freeindex";
    }
}
