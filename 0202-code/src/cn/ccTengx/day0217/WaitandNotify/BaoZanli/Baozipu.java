package cn.ccTengx.day0217.WaitandNotify.BaoZanli;

public class Baozipu extends Thread{
    private Baozi bz;

    public Baozipu(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int count=0;//用来标记何种包子
        while(true) {
            synchronized (bz) {
                if (bz.isState() == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count % 2 == 0) {
                    bz.setPi("白面");
                    bz.setXian("牛肉");
                } else {
                    bz.setPi("蔬菜面");
                    bz.setXian("三鲜");
                }
                count++;
                System.out.println("包子铺正在生产" + bz.getPi()  + bz.getXian() + "包子");
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.setState(true);
                System.out.println("包子已经做完");
                bz.notify();
            }
        }
    }
}
