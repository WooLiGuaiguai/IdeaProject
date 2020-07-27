package cn.ccTengx.day0217.WaitandNotify.BaoZanli;

public class Xiaofeiz extends Thread {
    private Baozi bz;

    public Xiaofeiz(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while(true){
            synchronized (bz){
                if (bz.isState() == false) {
                    try {
                        System.out.println("顾客正在等待包子生产");
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //等待之后就是被包子铺唤醒
                System.out.println("吃货正在吃"+bz.getPi()+bz.getXian()+"类型的包子");
                //修改包状态  然后唤醒包子铺继续生产
                bz.setState(false);
                bz.notify();
                System.out.println("包子吃完  店家继续生产");
                System.out.println("=================");
            }
        }
    }
}
