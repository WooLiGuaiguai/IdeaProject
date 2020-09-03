package 代码原理测试;

import java.io.UnsupportedEncodingException;

public class 字符所占字节 {
    public static void main(String[] args) throws UnsupportedEncodingException {
      /*Java采用unicode来表示字符，java中的一个char是2个字节，一个中文或英文字符的unicode编码都占2个字节
        在 GB 2312 编码或 GBK 编码中，一个英文字母字符存储需要1个字节，一个汉子字符存储需要2个字节。
        在UTF-8编码中，一个英文字母字符存储需要1个字节，一个汉字字符储存需要3到4个字节。
        在UTF-16编码中，一个英文字母字符存储需要2个字节，一个汉字字符储存需要3到4个字节（Unicode扩展区的一些汉字存储需要4个字节）。
        在UTF-32编码中，世界上任何字符的存储都需要4个字节。*/
        String a="你好 hello";
        System.out.println("UTF-8编码长度:"+a.getBytes("UTF-8").length);
        System.out.println("UTF-16编码长度:"+a.getBytes("UTF-16").length);
        System.out.println("UTF-32编码长度:"+a.getBytes("UTF-32").length);
        System.out.println("GBK编码长度:"+a.getBytes("GBK").length);
        System.out.println("GB2312编码长度:"+a.getBytes("GB2312").length);
    }
}
