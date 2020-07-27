package cn.ccTengx.day0216.ThreadSafeDemo;

public class RunnableImp implements Runnable {
    private int tickes=100;
    Object object=new Object();
    @Override
    public void run() {
        while(true) {
            synchronized (object) {
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
    }
}
