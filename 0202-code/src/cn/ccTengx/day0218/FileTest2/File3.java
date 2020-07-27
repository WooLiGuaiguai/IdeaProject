package cn.ccTengx.day0218.FileTest2;

import java.io.File;
import java.io.IOException;

public class File3 {
    public static void main(String[] args) throws IOException {
        show1();
    }
    public static void show1() throws IOException {
        File file=new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0218\\FileTest2\\aa\\bb\\cc");
        System.out.println(file.mkdirs());
        File file2=new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0218\\FileTest2\\dd");
        System.out.println(file2.mkdir());
        File file3=new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0218\\FileTest2\\dd\\a.txt");
        System.out.println(file3.createNewFile());
        System.out.println(file.delete());
    }
}
