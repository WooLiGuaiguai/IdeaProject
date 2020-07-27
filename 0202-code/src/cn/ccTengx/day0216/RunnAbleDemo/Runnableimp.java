package cn.ccTengx.day0216.RunnAbleDemo;

public class Runnableimp implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println(Thread.currentThread().getName()+" ------"+i);
        }
    }
}
