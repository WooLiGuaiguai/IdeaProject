package cn.ccTengx.day0216;

public class InnerClass {
    public static void main(String[] args) {
        new Thread(){
            public void run(){
                for (int i = 0; i < 6; i++) {
                    System.out.println(Thread.currentThread().getName()+"---->"+i);
                }
            }
        }.start();

        Runnable r=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    System.out.println("---->"+i+Thread.currentThread().getName());
                }
            }
        };
        new Thread(r).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    System.out.println(i+"---->"+Thread.currentThread().getName());
                }
            }
        }).start();
    }
}
