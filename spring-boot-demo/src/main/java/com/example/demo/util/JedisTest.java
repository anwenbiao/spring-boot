package com.example.demo.util;/**
 * Created by Administrator on 2018/3/20.
 */

import redis.clients.jedis.Jedis;

/**
 * 码农的一天
 * Jack.an
 */
public class JedisTest
{
    public static void main(String[] args){
        Jedis jedis=new Jedis("58.87.67.159");
        jedis.set("a","安文彪");
        String v = jedis.get("a");
        System.out.println(v);
    }

}
