package 练习题;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test0816 {
    public static void main(String[] args) {
        Integer []array={13,23,45,65,98};
        List<Integer> list=Arrays.asList(array);
        System.out.println(list);
        System.out.println(Arrays.toString(array));

        System.out.println("============");
        //+= 隐式的将加操作的结果类型强制转换为持有结果的类型。
        //如果两个整型相加，如 byte、short 或者 int，首先会将它们提升到 int 类型，然后在执行加法操作
        //b=a+b编译报错，因为a+b 操作会将 a、b 提升为 int 类型，将 int 类型赋值给 byte就会编译出错
        byte a=10,b=20;
        b+=a;
        System.out.println(b);
        //b=b+a;编译会报错

        System.out.println(3*0.1==0.3);
    }
}
