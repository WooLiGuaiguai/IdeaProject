package cn.ccTengx.day0210.StringBuilder;

import java.util.ArrayList;

public class DemoStringBuilder {
    /*
    java.lang.StringBuilder类:字符串缓冲区,可以提高字符串的效率
    构造方法:
        StringBuilder() 构造一个不带任何字符的字符串生成器，其初始容量为 16 个字符。
        StringBuilder(String str) 构造一个字符串生成器，并初始化为指定的字符串内容。
     StringBuilder的常用方法:
        public StringBuilder append(...)：添加任意类型数据的字符串形式，并返回当前对象自身。
     StringBuilder和String可以相互转换:
        String->StringBuilder:可以使用StringBuilder的构造方法
            StringBuilder(String str) 构造一个字符串生成器，并初始化为指定的字符串内容。
        StringBuilder->String:可以使用StringBuilder中的toString方法
            public String toString()：将当前StringBuilder对象转换为String对象。
        */
    public static void main(String[] args) {
        //append方法返回的是this,所以地址不发生改变，所以不需要就接收返回值
        StringBuilder str=new StringBuilder();
        System.out.println("str:"+str.append(123));//str:123
        str.append("abc").append(1).append(true).append(8.8).append('中');
        System.out.println(str);//123abc1true8.8中

        /*
        装箱:把基本类型的数据,包装到包装类中(基本类型的数据->包装类)
        构造方法:
        Integer(int value) 构造一个新分配的 Integer 对象，它表示指定的 int 值。
        Integer(String s) 构造一个新分配的 Integer 对象，它表示 String 参数所指示的 int 值。
        传递的字符串,必须是基本类型的字符串,否则会抛出异常 "100" 正确  "a" 抛异常
        静态方法:
        static Integer valueOf(int i) 返回一个表示指定的 int 值的 Integer 实例。
        static Integer valueOf(String s) 返回保存指定的 String 的值的 Integer 对象。
        拆箱:在包装类中取出基本类型的数据(包装类->基本类型的数据)
        成员方法:
        int intValue() 以 int 类型返回该 Integer 的值。*/
        Integer integer= new Integer("1");
        System.out.println(integer);//1
        //静态方法
        System.out.println(Integer.valueOf(100));
        /* 自动装箱与自动拆箱:基本类型的数据和包装类之间可以自动的相互转换
            自动装箱:直接把int类型的整数赋值包装类 */
        Integer in = 1;
        /*
            自动拆箱:in是包装类,无法直接参与运算,可以自动转换为基本数据类型,在进行计算
            in+2;就相当于 in.intVale() + 2 = 3
            in = in.intVale() + 2 = 3 又是一个自动装箱
         */
        in = in+2;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(in);
        //ArrayList集合无法直接存储整数,可以存储Integer包装类
        list.add(1); //-->自动装箱 list.add(new Integer(1));
        int a = list.get(0); //-->自动拆箱  list.get(0).intValue();


        System.out.println("=================================");
        /*基本类型与字符串类型之间的相互转换
        基本类型->字符串(String)
        1.基本类型的值+""  最简单的方法(工作中常用)
        2.包装类的静态方法toString(参数),不是Object类的toString() 重载
        static String toString(int i) 返回一个表示指定整数的 String 对象。
        3.String类的静态方法valueOf(参数)
        static String valueOf(int i) 返回 int 参数的字符串表示形式。
        字符串(String)->基本类型
        使用包装类的静态方法parseXXX("字符串");
        Integer类: static int parseInt(String s)
        Double类: static double parseDouble(String s)*/
        String string="123456789";
        int num=Integer.parseInt(string);
        String string2="12345.6789";
        double number=Double.parseDouble(string2);
        System.out.println(number);
        System.out.println(num);
    }

}
