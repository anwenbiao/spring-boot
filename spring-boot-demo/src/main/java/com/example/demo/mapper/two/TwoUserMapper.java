package com.example.demo.mapper.two;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/12/10.
 */

public interface TwoUserMapper {


    //@Select("select * from tb_user where id=#{id}")
    public User getUser(int id);

    //@Select("select * from tb_user ")
    public List<User>  getAllUser();

    public int outUser();

    public int inUser();

     int insertTwo(User user);
}
