package cn.ccTengx.day0224;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.stream().filter((String name)->{return name.startsWith("张");})
                .filter((String name)->{return name.length()==3;})
                .forEach((String name)->{
                    System.out.println(name);
                });
    }
}
