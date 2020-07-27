package cn.ccTengx.day0220.Demo2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferOutPut {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0220\\Demo2\\prop.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        bos.write("字节缓冲流的输入".getBytes());
        bos.close();

    }
}
