package cn.ccTengx.day0216.ThreadSafeDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImp2 implements Runnable {
    private static int tickes=100;
    Lock l=new ReentrantLock();
    @Override
    public void run() {
        while(true){
            l.lock();
            if (tickes > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + tickes + "张票");
                tickes--;
            }
            l.unlock();
        }
    }

    public static  synchronized  void payTickets1(){
        if (tickes > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在卖第" + tickes + "张票");
            tickes--;
        }
    }
    //同步方法的锁对象是实现类对象 new RunnableImpl() 也就是this
    public synchronized void payTickets(){
        if (tickes > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在卖第" + tickes + "张票");
            tickes--;
        }
    }
}
