package cn.ccTengx.day0213;

import java.util.LinkedList;

public class LinkedTessst {
    public static void main(String[] args) {
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("ccc");
        linkedList.add("ddd");
        System.out.println(linkedList);
        linkedList.push("caonima");
        linkedList.addFirst("woligecao");
        System.out.println(linkedList);
        String name="abc";
        String name1="bcd";
        int num=name.hashCode();
        int num2=name1.hashCode();
        System.out.println(num+" "+num2);
    }

}
