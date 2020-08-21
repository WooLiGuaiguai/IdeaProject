package 线程开发;
//用三个线程，顺序打印字母A-Z，输出结果是1A、2B、3C、1D 2E...
public class 线程同步 {
    private static char ch='A';
    private  static int i=0;
    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try{
                        int threadId=Integer.parseInt(Thread.currentThread().getName());
                        while(i<26){
                            if(i%3==threadId-1){
                                System.out.print(threadId+""+(char)ch+"  ");
                                ch++;
                                i++;
                                notifyAll();
                            }else{
                                wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread1=new Thread(runnable,"1");
        Thread thread2=new Thread(runnable,"2");
        Thread thread3=new Thread(runnable,"3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
