package cn.ccTengx.day0219;

import java.io.FileWriter;
import java.io.IOException;

public class DemoWrite {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0219\\e.txt");
        fw.write(67);
        fw.flush();
        fw.write(98);


        char []chars={'张','a','b'};
        fw.write(chars);
        fw.write(chars);
        fw.close();

    }
}
