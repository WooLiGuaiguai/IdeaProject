package cn.ccTengx.day0220.ReverseDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class OutputStreamWrite {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw =new OutputStreamWriter(
                new FileOutputStream("E:\\IdeaProject\\0202-code\\UTF-8.txt"));
        osw.write("你好  我是阿刁");
        osw.flush();
        //osw.close();

        OutputStreamWriter osw1 =new OutputStreamWriter(
                new FileOutputStream("E:\\IdeaProject\\0202-code\\GBK.txt",true),"GBK");
        osw1.write("你好  我是阿刁");
        osw1.flush();
        osw1.close();


    }
}
