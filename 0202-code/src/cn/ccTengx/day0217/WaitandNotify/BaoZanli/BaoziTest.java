package cn.ccTengx.day0217.WaitandNotify.BaoZanli;

public class BaoziTest {
    public static void main(String[] args) {
        Baozi baozi=new Baozi();
        //传递同一个包子对象
        Xiaofeiz xfz=new Xiaofeiz(baozi);
        Baozipu bzp=new Baozipu(baozi);
        xfz.start();
        bzp.start();
    }


}
