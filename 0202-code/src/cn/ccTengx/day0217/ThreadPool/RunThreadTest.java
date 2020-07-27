package cn.ccTengx.day0217.ThreadPool;

public class RunThreadTest implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程任务开始执行");
    }
}
