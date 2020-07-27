package cn.ccTengx.day0219;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DemoOutputStream1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0219\\a.txt");
        fos.write(97);//文本显示a  一个字节
        /*一次写多个字节的方法:
        - public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
                如果写的第一个字节是正数(0-127),那么显示的时候会查询ASCII表
                如果写的第一个字节是负数,那第一个字节会和第二个字节,两个字节组成一个中文显示,查询系统默认码表(GBK)
                GBK两个字节对应一个中文*/
        byte []bytes={65,66,67,68,69};
        fos.write(bytes);
        byte []bytes2={-65,66,-67,68,69};
        fos.write(bytes2);
        /* public void write(byte[] b, int off, int len) ：把字节数组的一部分写入到文件中
                int off:数组的开始索引
                int len:写几个字节*/
        fos.write(bytes,1,2);//
        /* 写入字符的方法:可以使用String类中的方法把字符串,转换为字节数组
                byte[] getBytes()  把字符串转换为字节数组  输入为中文时采取UTF-8 3个字节是一个字符*/
        System.out.println(Arrays.toString("你好".getBytes()));//[-28, -67, -96, -27, -91, -67]
        fos.write("你好".getBytes());
        fos.close();

        FileOutputStream fos1=new FileOutputStream("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx\\day0219\\a.txt",true);
        /*追加写/续写:使用两个参数的构造方法
        FileOutputStream(String name, boolean append)创建一个向具有指定 name 的文件中写入数据的输出文件流。
        FileOutputStream(File file, boolean append) 创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
        参数:
        String name,File file:写入数据的目的地
        boolean append:追加写开关
        true:创建对象不会覆盖源文件,继续在文件的末尾追加写数据
        false:创建一个新文件,覆盖源文件
        写换行:写换行符号  windows:\r\n    linux:/n    mac:/r                     */
        for (int i = 0; i < 10; i++) {
            fos1.write("你好".getBytes());
            fos1.write("\r\n".getBytes());
        }
        fos1.close();

    }
}
