package cn.ccTengx.day0222;

import java.util.function.Function;

public class Demo4Function {
    public static void main(String[] args) {
        String s="123456";
        change(s,(s1)->{
            return Integer.parseInt(s1);
        });//123456
        change2(s,(String s1)->{
            return 10+Integer.parseInt(s1);
        },(Integer integer)->{
            return integer+" ";
        });//123466
        String str = "赵丽颖,20";
        //调用change方法,参数传递字符串和3个Lambda表达式
        change3(str,(String str1)->{
            return str1.split(",")[1];//"赵丽颖,20"->"20"
        },(String str1)->{//"20"->20
            return Integer.parseInt(str1);
        },(Integer i)->{//20->120
            return i+100;
        });
    }
    /* 分析:1. 将字符串截取数字年龄部分，得到字符串；Function<String,String> "赵丽颖,20"->"20"
         2. 将上一步的字符串转换成为int类型的数字；Function<String,Integer> "20"->20
         3. 将上一步的int数字累加100，得到结果int数字 Function<Integer,Integer> 20->120*/
    public static void change3(String s, Function<String,String> fun1,
                             Function<String,Integer> fun2,Function<Integer,Integer> fun3){
        System.out.println(fun1.andThen(fun2).andThen(fun3).apply(s));
    }
    /*Function接口中的默认方法andThen:用来进行组合操作
    需求:把String类型的"123",转换为Inteter类型,把转换后的结果加10 把增加之后的Integer类型的数据,转换为String类型
    分析: 转换了两次
    第一次是把String类型转换为了Integer类型  所以我们可以使用Function<String,Integer> fun1 Integer i = fun1.apply("123")+10;
    第二次是把Integer类型转换为String类型 所以我们可以使用Function<Integer,String> fun2  String s = fun2.apply(i);
    我们可以使用andThen方法,把两次转换组合在一起使用 String s = fun1.andThen(fun2).apply("123");
    fun1先调用apply方法,把字符串转换为Integer fun2再调用apply方法,把Integer转换为字符串*/
    public static void change2(String str,Function<String,Integer> function1,Function<Integer,String> function2){
        System.out.println(function1.andThen(function2).apply(str));
    }
    /*java.util.function.Function<T,R>接口用来根据一个类型的数据得到另一个类型的数据，
        前者称为前置条件，后者称为后置条件。
       Function接口中最主要的抽象方法为：R apply(T t)，根据类型T的参数获取类型R的结果。
        使用的场景例如：将String类型转换为Integer类型。*/
    public static void change(String s, Function<String,Integer> function){
        Integer integer=function.apply(s);
        System.out.println(integer);
    }
}
