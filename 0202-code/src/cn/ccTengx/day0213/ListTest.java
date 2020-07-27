package cn.ccTengx.day0213;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("迪丽热巴");
        list.add("古力娜扎");
        list.add("马尔扎哈");
        list.add("佟丽娅啊");
        System.out.println(list);

        System.out.println(list.get(2));
        list.set(2,"岳云鹏");
        System.out.println(list);
        System.out.println(list.remove(2));
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("===========================");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            iterator.next();
        }
    }
}
