package cn.ccTengx.day0219;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class DemoInputStream2 {
    public static void main(String[] args) throws IOException {
        /*字节输入流一次读取多个字节的方法:
        int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
        1.方法的参数byte[]的作用
            起到缓冲作用,存储每次读取到的多个字节
            数组的长度一把定义为1024(1kb)或者1024的整数倍
        2.方法的返回值int是什么?
            每次读取的有效字节个数
        String类的构造方法
        String(byte[] bytes) :把字节数组转换为字符串
        String(byte[] bytes, int offset, int length) 把字节数组的一部分转换为字符串 offset:数组的开始索引 length:转换的字节个数*/
        FileInputStream fis=new FileInputStream("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0219\\c.txt");
        byte []bytes=new byte[2];
        int len=0;//记录每次读取的有效字节个数
        /*while((len=fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,5));
        }*/
        while((len=fis.read(bytes))!=-1){
            System.out.println(new String(bytes)+" "+len);
            //输出结果是   AB CD ED
        }
        /*System.out.print(fis.read(bytes)+" ");
        System.out.print(Arrays.toString(bytes)+" ");
        System.out.println(new String(bytes));

        System.out.print(fis.read(bytes)+" ");
        System.out.print(Arrays.toString(bytes)+" ");
        System.out.println(new String(bytes));

        System.out.print(fis.read(bytes)+" ");
        System.out.print(Arrays.toString(bytes)+" ");
        System.out.println(new String(bytes));*/

    }
}
