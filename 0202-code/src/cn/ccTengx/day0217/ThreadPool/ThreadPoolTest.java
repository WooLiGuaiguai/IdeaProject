package cn.ccTengx.day0217.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //获取线程池
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        //创建线程任务
        RunThreadTest threadTest=new RunThreadTest();
        executorService.submit(threadTest);
        executorService.submit(new RunThreadTest());
        executorService.submit(new RunThreadTest());
        executorService.submit(new RunThreadTest());
    }



}
