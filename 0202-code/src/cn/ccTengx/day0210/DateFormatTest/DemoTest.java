package cn.ccTengx.day0210.DateFormatTest;

import java.text.*;
import java.util.Date;

public class DemoTest {
    public static void main(String[] args) throws ParseException {
        Demo1();
    }
    /*  java.text.DateFormat:是日期/时间格式化子类的抽象类
    作用:
        格式化（也就是日期 -> 文本）、解析（文本-> 日期）
    成员方法:
        String format(Date date)  按照指定的模式,把Date日期,格式化为符合模式的字符串
        Date parse(String source)  把符合模式的字符串,解析为Date日期
    DateFormat类是一个抽象类,无法直接创建对象使用,可以使用DateFormat类的子类
    构造方法:
        SimpleDateFormat(String pattern)
          用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
        参数:
             String pattern:传递指定的模式
        模式:区分大小写的 y   年 M   月 d   日 H   时 m   分 s   秒
        写对应的模式,会把模式替换为对应的日期和时间
            "yyyy-MM-dd HH:mm:ss"
        注意:
            模式中的字母不能更改,连接模式的符号可以改变
             "yyyy年MM月dd日 HH时mm分ss秒"      */
    public static void Demo1() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(dateFormat.format(new Date()));
        System.out.println(dateFormat.parse("2020年02月10日 16时33分13秒"));
    }
}
