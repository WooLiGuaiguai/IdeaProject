package cn.ccTengx.day0222;

import java.util.function.Consumer;

public class Demo2 {
    public static void main(String[] args) {
        show1("迪丽热巴",(String name)->{//重写的是accept方法 调用的是show1方法
            System.out.println(new StringBuilder(name).reverse().toString());
        });
        show2("古力娜扎",
                (String name)->{System.out.println(new StringBuilder(name).reverse().toString()); },
                (String name)->{System.out.println(name);});
        String []strings={"马尔扎达,男","努尔基奇,男","朱古力礼,女"};
        show3(strings,(mes)->{//调用show3 然后进行到for循环时 重写里面的accept方法
            String name=mes.split(",")[0];//使用这个函数时 一定要确定分隔符的中英文是否和原字符串一致
            System.out.print("姓名是："+name);
        },(mes)->{
            String sex=mes.split(",")[1];
            System.out.println(" 性别是："+sex);
        });
    }
    /*
    java.util.function.Consumer<T>接口则正好与Supplier接口相反，
        它不是生产一个数据，而是消费一个数据，其数据类型由泛型决定。
    Consumer接口中包含抽象方法void accept(T t)，意为消费一个指定泛型的数据。*/
    public static void show1(String name,Consumer<String> con){
        con.accept(name);
    }
    /*
   Consumer接口的默认方法andThen
   作用:需要两个Consumer接口,可以把两个Consumer接口组合到一起,在对数据进行消费
   例如:   Consumer<String> con1   Consumer<String> con2  String s = "hello";
    con1.accept(s);   con2.accept(s);  连接两个Consumer接口  再进行消费
    con1.andThen(con2).accept(s); 谁写前边谁先消费 */
    public static void show2(String s, Consumer<String> con1,Consumer<String> con2 ){
        con1.andThen(con2).accept(s);
    }
    /*字符串数组当中存有多条信息，请按照格式“姓名：XX。性别：XX。”的格式将信息打印出来。
        要求将打印姓名的动作作为第一个Consumer接口的Lambda实例，将打印性别的动作作为第二个Consumer接口的Lambda实例，
        将两个Consumer接口按照顺序“拼接”到一起。*/
    public static void show3(String []s, Consumer<String> con1,Consumer<String> con2 ){
        for(String mes:s){
            con1.andThen(con2).accept(mes);
        }
    }

}
