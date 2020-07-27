package cn.ccTengx.day0214;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        show1();
        System.out.println("========================");
        show2();
    }

    private static void show2() {
        HashMap<Person,String> hashMap=new HashMap<>();
        hashMap.put(new Person(20,"bbb"),"上海");
        hashMap.put(new Person(30,"ccc"),"深圳");
        hashMap.put(new Person(10,"aaa"),"南京");
        hashMap.put(new Person(10,"aaa"),"秦皇岛");
        Set<Person> set = hashMap.keySet();
        Iterator<Person> iterator = set.iterator();
        while(iterator.hasNext()){
            Person person=iterator.next();
            System.out.println(person+"   "+hashMap.get(person));
        }
    }

    private static void show1() {
        HashMap<String,Person> map=new HashMap<>();
        map.put("北京",new Person(10,"aaa"));
        map.put("上海",new Person(20,"bbb"));
        map.put("深圳",new Person(30,"ccc"));
        map.put("北京",new Person(70,"aaa"));
        Set<Map.Entry<String, Person>> entries = map.entrySet();
        for (Map.Entry<String, Person> entry : entries) {
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }
}
