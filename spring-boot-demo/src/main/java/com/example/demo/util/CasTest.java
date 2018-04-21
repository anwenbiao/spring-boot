package com.example.demo.util;/**
 * Created by Administrator on 2018/3/10.
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 码农的一天
 * Jack.an
 */
public class CasTest {

     static AtomicInteger atomicInteger=new AtomicInteger(100);
    static CountDownLatch countDownLatch=new CountDownLatch(1);

    public static void main(String[] args){
        /*for (int i=0;i<20;i++){
            new Thread(()->{
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               addAndDecrement();
            }).start();
        }
        countDownLatch.countDown();*/
        }

    public  static void addAndDecrement(){
        atomicInteger.decrementAndGet();
        System.out.println(atomicInteger.get());
    }
}
