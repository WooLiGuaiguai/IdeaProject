package cn.ccTengx.day0214;

import java.util.*;

public class MapTestDemo {
    public static void main(String[] args) {
        //输入一个字符串
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String string = sc.next();
        HashMap<Character,Integer> hashMap=new HashMap<>();
        char[] chars=string.toCharArray();
        for (char aChar : chars) {
            if(hashMap.containsKey(aChar)){
                Integer integer=hashMap.get(aChar);
                integer++;
                hashMap.put(aChar,integer);
            }else{
                hashMap.put(aChar,1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Character,Integer> entry=iterator.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
