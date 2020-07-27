package cn.ccTengx.day0217.LamdaDemo;

import java.util.Arrays;
import java.util.Comparator;

public class CookTest {
    public static void main(String[] args) {
        Cooker(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("赶紧吃饭");
            }
        });

        Cooker(()->{ System.out.println("赶紧shuijiao");});
        Person []arr={
                new Person("刘艳",38),
                new Person("迪丽热巴",18),
                new Person("杨幂",33)};
        Arrays.sort(arr,(Person o1, Person o2)->{
            return o1.getAge()-o2.getAge();
        });
        for (Person person : arr) {
            System.out.println(person);
        }
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
            });

        System.out.println("==============================下面实现接口Cal");
        //有参数有返回值 有一个接口类Cal 抽象方法calculate 测试类中定义静态函数
       calculate(10, 20, new Cal() {
            @Override
            public int callculate(int a,int b) {
                return a+b;
            }
        });
        calculate(50,20,(int a,int b)->{
            return a+b;
        });

    }
    public static  int  calculate(int a,int b,Cal cal){
        int sum=cal.callculate(a,b);
        return sum;
    }
    public static void Cooker(Cook cook){
        cook.makeFood();
    }

}


