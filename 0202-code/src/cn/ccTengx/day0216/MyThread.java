package cn.ccTengx.day0216;

public class MyThread extends Thread{
    MyThread(){}
    MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
       // String name=getName();
       // System.out.println(name);
        //String name="wangba";

        Thread thread=Thread.currentThread();
        System.out.println(thread.getName());
    }

}
