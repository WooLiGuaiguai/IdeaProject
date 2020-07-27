package cn.ccTengx.day0218.FileTest2;

import java.io.File;

public class File2 {
    public static void main(String[] args) {
        //show1();
        //show2();
        show04();
    }
    /*
       public long length()  ：返回由此File表示的文件的长度。
       获取的是构造方法指定的文件的大小,以字节为单位
       注意:
           文件夹是没有大小概念的,不能获取文件夹的大小
           如果构造方法中给出的路径不存在,那么length方法返回0
    */
    private static void show04() {
        File f1 = new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0218\\FileTest2\\File2.java");
        System.out.println(f1.length());//2500字节

        File f2 = new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0218");
        System.out.println(f2.length());//0   文件夹没有大小概念的

        File f3 = new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0218\\FileTest4");
        System.out.println(f3.length());//0    文件不存在
    }
    /*
        public String getName()  ：返回由此File表示的文件或目录的名称。
        获取的就是构造方法传递路径的结尾部分(文件/文件夹)
     */
    public static void show2(){
        File file=new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0218\\FileTest1");
        System.out.println(file.getName());//FileTest1
    }
    /*
       public String getPath() ：将此File转换为路径名字符串 构造方法中是啥 就获取啥
       重写的toString方法中 调用的就是getPath方法
    /*
        public String getAbsolutePath() ：返回此File的绝对路径名字符串。
        获取的构造方法中传递的路径  无论路径是绝对的还是相对的,getAbsolutePath方法返回的都是绝对路径
        如果java文件与路径文件不在同一个包 绝对路径会显示根路径E:\IdeaProject\相对路径*/
    public static void show1(){
        File file1=new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0218\\FileTest1");
        String str=file1.getAbsolutePath();
        System.out.println(str);
        File file2=new File("FileTest1");//E:\IdeaProject\FileTest1
        String str2=file2.getAbsolutePath();
        System.out.println(str2);
        File file3=new File("a.txt");//E:\IdeaProject\a.txt
        String str3=file3.getAbsolutePath();
        System.out.println(str3);

    }
}
