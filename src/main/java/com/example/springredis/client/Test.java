package com.example.springredis.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class Test {

    private ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();

    private ExecutorService executorService = Executors.newFixedThreadPool(8);

    @GetMapping("/test")
    public String test() throws InterruptedException {
        chm.put("001","001v");
        chm.put("002","002v");
        chm.put("003","003v");

        CountDownLatch countDownLatch = new CountDownLatch(chm.size());
        System.out.println(countDownLatch.getCount());

        ConcurrentHashMap.KeySetView<String, String> strings = chm.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            executorService.execute(new ThreadTask(chm, iterator.next(), countDownLatch));
        }

        countDownLatch.await();

        System.out.println("主线程完成任务");

        return "666";
    }
}
