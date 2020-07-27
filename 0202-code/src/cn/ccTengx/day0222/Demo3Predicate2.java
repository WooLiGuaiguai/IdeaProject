package cn.ccTengx.day0222;

import java.util.function.Predicate;

/*  Predicate接口三个默认方法  and or 取反
    需求:判断一个字符串,有两个判断的条件  1.判断字符串的长度是否大于5   2.判断字符串中是否包含a
    两个条件必须同时满足,我们就可以使用&&运算符连接两个条件

    Predicate接口中有一个方法and,表示并且关系,也可以用于连接两个判断条件
    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> this.test(t) && other.test(t);}     方法内部的两个判断条件,也是使用&&运算符连接起来的   */
public class Demo3Predicate2{
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2){
        return pre1.and(pre2).test(s);//等价于return pre1.test(s) && pre2.test(s);
    }
    public static boolean checkString2(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.or(pre2).test(s);//等价于return pre1.test(s) || pre2.test(s);
    }public static boolean checkString3(String s, Predicate<String> pre) {
        return pre.negate().test(s);//等价于return !pre.test(s);
    }
    public static void main(String[] args) {
        String s = "abcdef";
        //调用checkString方法,参数传递字符串和两个Lambda表达式
        boolean b = checkString(s,(String str)->{
            return str.length()>5;
        },(String str)->{
            return str.contains("a");
        });
        boolean c = checkString2(s,(String str)->{
            return str.length()>7;
        },(String str)->{
            return str.contains("a");
        });
        boolean d = checkString3(s,(String str)->{
            return str.length()>7;
        });
        System.out.println(b+" "+c+" "+d);
    }
}
