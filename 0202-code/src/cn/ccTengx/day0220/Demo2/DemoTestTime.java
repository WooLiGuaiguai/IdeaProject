package cn.ccTengx.day0220.Demo2;

import java.io.*;

public class DemoTestTime {
    /*
    * 首先要从硬盘中读到内存中*/
    public static void main(String[] args) throws IOException {
        long s=System.currentTimeMillis();
        FileInputStream fis=new FileInputStream("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0220\\Demo2\\prop.txt");
        BufferedInputStream   bis=new BufferedInputStream(fis);
        FileOutputStream fos=new FileOutputStream("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0220\\Demo2\\prop.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        int len=0;
        while((len=bis.read())!=-1){
            bos.write(len);
        }
        bos.close();
        bis.close();
        long time=System.currentTimeMillis();
        System.out.println(time-s);
    }
}
