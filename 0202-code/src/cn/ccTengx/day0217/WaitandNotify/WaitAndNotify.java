package cn.ccTengx.day0217.WaitandNotify;

public class WaitAndNotify {
    /*
    注意:
        顾客和老板线程必须使用同步代码块包裹起来,保证等待和唤醒只能有一个在执行
        同步使用的锁对象必须保证唯一
        只有锁对象才能调用wait和notify方法
    Obejct类中的方法
    void wait()
          在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
    void notify()
          唤醒在此对象监视器上等待的单个线程。
          会继续执行wait方法之后的代码*/
    public static void main(String[] args) {
        Object obj=new Object();
        new Thread(){
            @Override
            public void run() {
                int count=1;
                while (true){
                    synchronized (obj) {
                        System.out.println("告诉老板要的包的种类和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("包子已经ok  开始吃");
                        System.out.println("======================第"+count+"个包子已经吃完");
                        count++;
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        System.out.println("老板做好包子 递给你 停止等待");
                        obj.notify();
                    }
                }
            }
        }.start();
    }
}
