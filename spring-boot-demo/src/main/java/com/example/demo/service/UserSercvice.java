package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/12/10.
 */
public interface UserSercvice {

    public User getUser(int id);

    public List<User> getAllUser();
}
