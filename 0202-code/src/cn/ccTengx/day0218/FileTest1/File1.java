package cn.ccTengx.day0218.FileTest1;

import java.io.File;

public class File1 {
    public static void main(String[] args) {
        show1();
        show2("c:\\","abc.txt");
    }

    public static void show2(String parent,String children){
        File file=new File(parent,children);
        System.out.println(file);
    }
    public static void show1(){
        File file1=new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0218");
        System.out.println(file1);
        File file2=new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0218\\a.txt");
        System.out.println(file2);
        File file3=new File("c.txt");
        System.out.println(file3);
    }
}
