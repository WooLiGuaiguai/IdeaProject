package cn.ccTengx.day0213.CollectionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"w","b","c","poi","qwe");
        System.out.println(list);
        Collections.shuffle(list);//打乱集合的顺序
        System.out.println(list);

        Collections.sort(list);//默认升序排序
        System.out.println(list);

        ArrayList<Person> list1=new ArrayList<>();
        list1.add(new Person(10,"a","aa"));
        list1.add(new Person(90,"q","qq"));
        list1.add(new Person(70,"r","rr"));
        list1.add(new Person(8,"g","gg"));
        Collections.sort(list1);
        System.out.println(list1);

        ArrayList<Person> list2=new ArrayList<>();
        list2.add(new Person(10,"a","aa"));
        list2.add(new Person(90,"q","qq"));
        list2.add(new Person(70,"r","rr"));
        list2.add(new Person(90,"g","gg"));
        Collections.sort(list2, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getNum()-o2.getNum()==0) {
                    return o1.getName().charAt(0)-o2.getName().charAt(0);
                }else
                    return o1.getNum()-o2.getNum();
            }
        });
        System.out.println(list2);
    }
}
