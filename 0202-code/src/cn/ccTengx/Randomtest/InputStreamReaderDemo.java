package cn.ccTengx.Randomtest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {

          GBK_read();
        System.out.println();
          UTF_8();



    }
    private static void UTF_8() throws IOException{
        FileInputStream fis=new FileInputStream("E:\\IdeaProject\\0202-code\\UTF-8.txt");
        InputStreamReader isr=new InputStreamReader(fis);
        int len=0;
        while((len=isr.read())!=-1){
            System.out.print((char) len);
        }
        isr.close();
    }
    private static void GBK_read() throws IOException {
        FileInputStream fis=new FileInputStream("E:\\IdeaProject\\0202-code\\GBK.txt");
        InputStreamReader isr=new InputStreamReader(fis,"GBK");
        int len=0;
        while((len=isr.read())!=-1){
            System.out.print((char) len);
        }
        isr.close();
    }

}
