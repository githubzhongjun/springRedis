package com.example.springredis.client;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class ThreadTask implements Runnable{
    private ConcurrentHashMap<String, String> chm = new ConcurrentHashMap();

    private String key;

    private CountDownLatch countDownLatch;


    public ThreadTask(ConcurrentHashMap<String, String> chm, String key, CountDownLatch countDownLatch) {
        this.chm = chm;
        this.key = key;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        if (chm.size() == 0 ){
            return;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " key " + key + " value " + chm.get(key) );

        System.out.println( Thread.currentThread().getName() + " 处理业务 ");

        countDownLatch.countDown();

    }
}
