package 练习题;

import java.io.UnsupportedEncodingException;

public class test0814 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Integer f1 = 100, f2 = 100, f3 = 128, f4 = 128;
        Integer f5=new Integer(127);
        Integer f6=new Integer(127);
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        System.out.println(f5 == f6);
        //jvm在运行时创建了一个缓存区域，并创建了一个integer的数组。这个数组存储了-128至127的值
        //因此如果integer的值在-128至127之间，则是去缓存里面获取。因此f1,f2指向的是同一个内存地址。
        //因为128超过了这个缓存区域，因此第二次赋值的时候是重新开辟了两个内存地址。
        //第三次因为使用了new关键字开辟内存空间,因此内存地址不再相同

        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
        System.out.println("------------");
        String str1 = new StringBuilder("计算机").append("软件").toString();
        String str2 = new StringBuilder("Ja").append("va").toString();
        String str3 = "java";
        String str4 = new String("java");
        System.out.println(str1.intern() == str1);//因为之前没有所以创建的引用和intern()返回的引用相同
        System.out.println(str2.intern() == str2);//"java在StringBuilder()之前已经出现过",所以intern()返回的引用与新创建的引用不是同一个
        System.out.println(str3 == str4);

        //首先分析==，他判断的是地址,equals比较的是值是否相同
        //在定义变量的时候赋值，如果赋值的是静态的字符串，就会执行进入字符串池的操作，如果池中含有该字符串，则返回引用
        //字符串相加的时候如果存在变量，就不会进入字符串池
        String a = "abc";
        String b = "abc";
        String c = "a" + "b" + "c";
        String f="bc";
        String d = "a" + f;

        System.out.println(a == b);//true
        System.out.println(a == c);//true
        System.out.println(a == d);//false
        System.out.println(c == d);//false

        //然后分析intern()
        //1. String 对象的intern 方法会得到字符串对象在常量池中对应的版本的引用
        //(如果常量池中有一个字符串与 String 对象的 equals 结果是 true）
        //2.如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返回常量池中字符串的引用；
        //字符串相加的时候，都是静态字符串的结果会添加到字符串池，如果其中含有变量则不会进入字符串池中。
        //但是字符串一旦进入字符串池中，就会先查找池中有无此对象。
        //如果有此对象，则让对象引用指向此对象。如果无此对象，则先创建此对象，再让对象引用指向此对象。
        String A = new String("ab");
        String B = new String("ab");
        String C = "ab";
        String D = "a" + "b";
        String E = "b";
        String F = "a" + E;

        System.out.println(B.intern() == A);//false
        System.out.println(B.intern() == C);//true
        System.out.println(B.intern() == D);//true
        System.out.println(B.intern() == F);//false
        System.out.println(B.intern() == A.intern());//true

        String ss1 = "你好";
        String ss2 = new String(ss1.getBytes("GB2312"), "ISO-8859-1");
        System.out.println(ss1);
        System.out.println(ss2);
    }
}
