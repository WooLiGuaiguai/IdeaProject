package 排序;

import java.util.*;

public class 前K个高频元素 {
    public static void main(String[] args) {
       int [] nums = {1,1,1,2,2,3};
        List<Integer> list=topKFrequent(nums,2);
        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    public static List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer>[] numlist=new ArrayList[nums.length+1];
        for (int num : map.keySet()) {
            int frequent=map.get(num);//获取它的频数
            if(numlist[frequent]==null){
                numlist[frequent]=new ArrayList<>();//没有频数为frequent的集合那么就新建一个
            }
            numlist[frequent].add(num);//把相同频数的数字添加到一个集合当中
        }
        //然后开始查找
        List<Integer> list=new ArrayList<>();
        for(int i=numlist.length-1;i>=0&&k>list.size();i--){
            if(numlist[i]==null){
                continue;
            }
            if(numlist[i].size()<=k){
                list.addAll(numlist[i]);
            }else{
                list.addAll(numlist[i].subList(0,k-list.size()));//现在list还缺少的个数
            }
        }
        return list;
    }
}
