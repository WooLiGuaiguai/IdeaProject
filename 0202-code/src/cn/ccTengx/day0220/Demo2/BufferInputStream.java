package cn.ccTengx.day0220.Demo2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0220\\Demo2\\prop.txt");
        BufferedInputStream bis=new BufferedInputStream(fis);
        int len=0;
        byte []bytes=new byte[1024];
        while((len=bis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        bis.close();
    }
}
