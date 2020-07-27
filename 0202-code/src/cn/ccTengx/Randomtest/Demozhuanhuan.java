package cn.ccTengx.Randomtest;

import java.io.*;

public class Demozhuanhuan {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream("E:\\IdeaProject\\0202-code\\GBK.txt"),"GBK");
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("E:\\IdeaProject\\0202-code\\新的UTF-8.txt"));
        int lem=0;
        while((lem=isr.read())!=-1){
            osw.write(lem);
        }
        osw.close();
        isr.close();
    }
}
