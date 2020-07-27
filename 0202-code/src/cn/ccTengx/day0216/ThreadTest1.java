package cn.ccTengx.day0216;

public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();

        new MyThread("钱多多").start();
        System.out.println(Thread.currentThread().getName());
    }

}
