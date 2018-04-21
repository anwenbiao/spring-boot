package com.example.demo.util;/**
 * Created by Administrator on 2018/3/8.
 */

import com.google.common.util.concurrent.RateLimiter;
import com.sun.javaws.exceptions.CouldNotLoadArgumentException;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 码农的一天
 * Jack.an
 */
public class MicLimiter {

   final static RateLimiter rateLimiter=RateLimiter.create(10);

   static  Random random=new Random();

    public static void main(String[] args){
        /*CountDownLatch countDownLatch=new CountDownLatch(1);
        for (int i=0;i<100;i++) {
            new  Thread(()->{
                try {
                    //线程等待   模拟并发
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {

                    limiter();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ).start();
        }
        countDownLatch.countDown();*/
    }

    public static void limiter() throws InterruptedException {
        //采用tryAcquire（）需要添加睡眠时间才能有效的看出结果
        long l=random.nextInt(1000);
        Thread.sleep(l);
        if(rateLimiter.tryAcquire()){
            System.out.println("正常处理.....");
        }else{
            System.out.println("出现异常了");
        }

      //这是线程阻塞的  返回值是double
        /*  rateLimiter.acquire();
        long start = System.currentTimeMillis();
        System.out.println("开始时间："+start);
        System.out.println("正常处理");*/
    }
}
