package cn.ccTengx.day0210;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Date;

public class DemoTest {
    public static void main(String[] args) {
        /*
        Person类默认继承了Object类,所以可以使用Object类中的toString方法
        String toString() 返回该对象的字符串表示。*/
        Person p=new Person("张三",20);
        System.out.println(p.toString());//cn.ccTengx.day0210.Person@1b6d3586
        //直接打印对象的名字,其实就是调用对象的toString  p=p.toString();
        //看一个类是否重写了toString,直接打印这个类的对象即可,如果没有重写toString方法那么打印的是对象的地址值
        System.out.println(p.toString());//重写之后，Person{name='张三', number=20}
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println(arrayList);//[1, 2]  进行重写了
        /*
        Person类默认继承了Object类,所以可以使用Object类的equals方法 引用类型比较地址值
        重写
        public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return number == person.number &&
                Objects.equals(name, person.name);
        null.equals("aaa")//  错   null不能调用方法 否则会空指针异常
        Objects.equals 防止空指针异常
        }*/
        String a="aaa";
        String b=null;
        System.out.println(Objects.equals(a,"bbb"));
        Person person=new Person("黄鳝",20);
        Person person2=new Person("鲫鱼",20);
        Person person3=new Person("黄鳝",20);
        System.out.println(person.equals(person2));
        System.out.println(person.equals(person3));

/*
    java.util.Date:表示日期和时间的类    类 Date 表示特定的瞬间，精确到毫秒。
    把日期转换为毫秒:
        当前的日期:2088-01-01
        时间原点(0毫秒):1970 年 1 月 1 日 00:00:00(英国格林威治)
        就是计算当前日期到时间原点之间一共经历了多少毫秒 (3742767540068L)
    注意:
        中国属于东八区,会把时间增加8个小时
        1970 年 1 月 1 日 08:00:00*/
        System.out.println(System.currentTimeMillis());//获取当前系统时间到1970 年 1 月 1 日 00:00:00经历了多少毫秒
        Demo1();     Demo2();      Demo3();
    }
    /*  Date类的空参数构造方法
        Date() 获取当前系统的日期和时间*/
    public static void Demo1(){
        Date date=new Date();
        System.out.println(date);
    }
    /*  Date类的带参数构造方法
        Date(long date) :传递毫秒值,把毫秒值转换为Date日期*/
    public static void Demo2(){
        Date date=new Date(10L);
        System.out.println(date);
    }
    /*   long getTime() 把日期转换为毫秒值(相当于System.currentTimeMillis()方法)
         返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。*/
    public static void Demo3(){
        Date date=new Date();
        long time=date.getTime();
        System.out.println(time);
    }
}
