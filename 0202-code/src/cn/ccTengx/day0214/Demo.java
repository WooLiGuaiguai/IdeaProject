package cn.ccTengx.day0214;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Demo {
    public static void main(String[] args) {
        String str="aacc";
        System.out.println(FirstNotRepeatingChar(str));
        int [] num={1,3,4,5,6,5,4,7,9,4,4,4,4};
        System.out.println(GetNumberOfK(num,0));
        int [] num2={1,3,1,5,5,4,4,7};
        FindNumsAppearOnce(num2);
    }
    public static void FindNumsAppearOnce(int [] array) {
        if(array.length==0){
            System.out.println("长度为0");
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int in:array){
            if(map.containsKey(in)){
                Integer integer=map.get(in);//integer是value值
                integer++;
                map.put(in,integer);
            }else{
                map.put(in,1);
            }
        }
        int []arr=new int[2];
        int i=0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue()==1){//如果找到这个key
                arr[i]=next.getKey();
                i++;
            }
        }
        System.out.println(arr[0]+"  "+arr[1]);

    }
    public static int GetNumberOfK(int [] array , int k){
        if(array.length==0){
            return 0;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int in:array){
            if(map.containsKey(in)){
                Integer integer=map.get(in);//integer是value值
                integer++;
                map.put(in,integer);
            }else{
                map.put(in,1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getKey()==k){//如果找到这个key
                return next.getValue();//返回出现次数
            }
        }
        return 0;//如果没有找到 返回0
    }
    public static int FirstNotRepeatingChar(String str) {
        if(str.length()<0||str.length()>10000){
            return 0;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        char []chars=str.toCharArray();
        for (char aChar : chars) {
            if(map.containsKey(aChar)){
                Integer in=map.get(aChar);
                in++;
                map.put(aChar,in);
            }else{
                map.put(aChar,1);
            }
        }
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(map.get(c)==1)
                return i;
        }
        return -1;
        /*Set<Map.Entry<Character,Integer>> set=map.entrySet();
        Iterator<Map.Entry<Character,Integer>>iterator= set.iterator();
        int index=0;
        boolean flag=false;
        while(iterator.hasNext()){
            Map.Entry<Character,Integer> entry=iterator.next();
            if(entry.getValue()==1){
                flag=true;
                break;
            }
        }
        if(flag==false) return -1;
        return index-1;
        while(iterator.hasNext()){
            Map.Entry<Character,Integer> entry=iterator.next();
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }*/
    }
}
