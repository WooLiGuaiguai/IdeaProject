package cn.ccTengx.day0210.Calendar;

import java.util.Calendar;

public class DemoCalTest {
    /*
    java.util.Calendar类:日历类
    Calendar类是一个抽象类,里边提供了很多操作日历字段的方法(YEAR、MONTH、DAY_OF_MONTH、HOUR )
    Calendar类无法直接创建对象使用,里边有一个静态方法叫getInstance(),该方法返回了Calendar类的子类对象
    static Calendar getInstance() 使用默认时区和语言环境获得一个日历。
    Calendar类的常用成员方法:
        public int get(int field)：返回给定日历字段的值。
        public void set(int field, int value)：将给定的日历字段设置为给定值。
        public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
        public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
    成员方法的参数:
        int field:日历类的字段,可以使用Calendar类的静态成员变量获取
            public static final int YEAR = 1;	年
            public static final int MONTH = 2;	西方国家月份是0-11
 */
    public static void main(String[] args) {
        Calendar c=Calendar.getInstance();
        System.out.println(c.getTime());
        c.get(Calendar.MONTH);
        c.set(Calendar.YEAR,1997);
        c.add(Calendar.DAY_OF_MONTH,88);
        System.out.println(c.getTime());
    }
}
