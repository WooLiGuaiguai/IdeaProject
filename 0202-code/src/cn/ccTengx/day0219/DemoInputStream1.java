package cn.ccTengx.day0219;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoInputStream1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0219\\b.txt",true);
        for(int i=0;i<5;i++){
            fos.write("你好".getBytes());
        }
        fos.close();
        FileInputStream fis=new FileInputStream("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0219\\b.txt");
        int a=0;
        /*   while循环结束条件,read读取到最后的时候 会输出-1
        布尔表达式(len = fis.read())!=-1
        1.fis.read():读取一个字节
        2.len = fis.read():把读取到的字节赋值给变量len
        3.(len = fis.read())!=-1:判断变量len是否不等于-1*/
        while((a=fis.read())!=-1) {
            System.out.print( a+"   ");
        }
        fis.close();
    }
}
