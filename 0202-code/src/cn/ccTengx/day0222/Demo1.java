package cn.ccTengx.day0222;

import java.util.Arrays;
import java.util.Comparator;

public class Demo1 {
    /*Lambda的特点:延迟加载
            Lambda的使用前提,必须存在函数式接口*/
    public static void main(String[] args) {
        String str1="abc";
        String str2="你好";
        show1(1,(str3)->{
            return str1+str2+str3;
        });

        String[] strings={"dddddd","bbbb","cccsdasdas"};
        Arrays.sort(strings,getComparator());
        System.out.println(Arrays.toString(strings));
    }
    /*     使用Lambda表达式作为参数传递,仅仅是把参数传递到showLog方法中
            只有满足条件,才会调用接口MessageBuilder中的方法builderMessage,才会进行字符串的拼接
            如果条件不满足,那么MessageBuilder接口中的方法builderMessage也不会执行,所以拼接字符串的代码也不会执行
            所以不会存在性能的浪费*/
    public static void show1(int level,MyIntere mi){//函数式接口作为方法参数
        String str="   张家界";
        if(level==1){
            System.out.println(mi.show(str));
        }
    }
    //方法的返回值是函数式接口 可以返回匿名对象类  也可以返回lambda表达式
    public static Comparator<String> getComparator(){
        return (String o1,String o2)->{ return o2.length()-o1.length();};
    }
}
