package cn.ccTengx.day0219;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class DemoReader {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0219\\d.txt",true);
        fos.write("你好".getBytes());
        byte []bytes={68,69,70,71,72};
        fos.write(bytes);
        fos.close();

        FileReader fr=new FileReader("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0219\\d.txt");
        /*
                String类的构造方法
                String(char[] value) 把字符数组转换为字符串
                String(char[] value, int offset, int count) 把字符数组的一部分转换为字符串 offset数组的开始索引 count转换的个数
             */
        int len=0;//读取的字符串长度
        while((len=fr.read())!=-1){
            System.out.print((char) len+"  ");
        }
        System.out.println("====================");
        char []chars=new char[1024];
        int len1=0;
        while((len1=fr.read(chars))!=-1){
            System.out.println(new String(chars));
        }
        while((len1=fr.read(chars))!=-1){
            System.out.println(new String(chars,0,10));
        }
        fr.close();
    }
}
