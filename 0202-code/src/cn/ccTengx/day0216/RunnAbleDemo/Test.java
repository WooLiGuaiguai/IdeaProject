package cn.ccTengx.day0216.RunnAbleDemo;

public class Test {
    public static void main(String[] args) {
        Runnableimp imp1=new Runnableimp();
        Thread thread1=new Thread(imp1);
        thread1.start();
        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
