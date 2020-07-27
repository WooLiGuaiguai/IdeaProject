package cn.ccTengx.day0205;

public class StringTest {

    public static void main(String[] args) {
        //public String() ：初始化新创建的 String对象，以使其表示空字符序列。
        //public String(char[] value) ：通过当前参数中的字符数组来构造新的String。
        //public String(byte[] bytes) ：通过使用平台的默认字符集解码当前参数中的字节数组来构造新的String
        // 无参构造
        String str = new String();
        // 通过字符数组构造
        char chars[] = {'a', 'b', 'c'};
        String str2 = new String(chars);
        // 通过字节数组构造
        byte bytes[] = { 97, 98, 99 };
        String str3 = new String(bytes);

        //equals 方法
        String string1="abc";
        String string2="abc";
        String string3="Abc";
        String string4=null;
        System.out.println("abc".equals(string4));//如果比较双方一个常量一个变量，常量放前面
        //System.out.println(string4.equals("abc"));//会报错 空指针异常
        System.out.println("abc".equals(string1));
        System.out.println(string3.equalsIgnoreCase(string2));//忽略大小写
    }

}
