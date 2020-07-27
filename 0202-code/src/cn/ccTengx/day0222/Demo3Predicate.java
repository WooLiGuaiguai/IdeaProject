package cn.ccTengx.day0222;

import java.util.function.Predicate;

public class Demo3Predicate {
    public static void main(String[] args) {
        String s="ag";
        boolean b=checkString(s,(string)->{
            if (s.length()<5){ return true;  }
            else return false;
        });
        System.out.println(b);
    }
    /*java.util.function.Predicate<T>接口
    作用:对某种数据类型的数据进行判断,结果返回一个boolean值
    Predicate接口中包含一个抽象方法：  boolean test(T t):用来对指定数据类型数据进行判断的方法
    结果:符合条件,返回true  不符合条件,返回false*/
    public static boolean checkString(String string, Predicate<String> predicate){
        return predicate.test(string);
    }
}
