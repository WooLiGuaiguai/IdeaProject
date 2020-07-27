package cn.ccTengx.day0216.ThreadSafeDemo;

import java.util.*;

public class ThreadSafeTest {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        /*RunnableImp2 run = new RunnableImp2();
        //创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        //调用start方法开启多线程
        t0.start();
        t1.start();
        t2.start();*/
        /*int []a=new int[10];
        int i=0;
        int j=5;
        for(;i<a.length&&i<j;i++,j=i+1){
            System.out.println(i);
            System.out.println(j);
        }*/
        int []a={1,2,4,7,11,15};
        System.out.println(FindNumbersWithSum(a,15));
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            ArrayList<Integer> aList=new ArrayList<>();
            for(int j=i+1;j<array.length;j++){
                if(array[i]+array[j]==sum){
                    aList.add(array[i]);
                    aList.add(array[j]);
                    aList.add(array[i]*array[j]);
                }
            }
            if(!aList.isEmpty()){
                list.add(aList);
            }
        }
        //如果aList为空 那么不能直接取值给list  会空指针异常 所以要返回一个空集合
        if(list.size()==0){return new ArrayList<Integer>();}
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            //每个集合的最后一个元素是乘积  比较乘积来进行排序输出乘积最小的
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(2).compareTo(o2.get(2));
            }
        });
        ArrayList<Integer> finaList=new ArrayList<>();
        ArrayList<Integer> result=list.get(0);
        for(int i=0;i<result.size()-1;i++){
            finaList.add(result.get(i));
        }
        return finaList;

    }

}
