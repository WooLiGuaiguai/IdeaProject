package 哈希表;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
public class 最长和谐子序列 {
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,3,2,2,8,2,3,7}));
    }
    public static int findLHS(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();//key存储nums中的值  values存储出现的次数
        for (int num : nums) {//获取映射
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int longarr=0;
        for (int key : map.keySet()) {//对当前遍历到的key来说找比它大一的
            if(map.containsKey(key+1)){
                longarr=Math.max(longarr,map.get(key)+map.get(key+1));
            }
        }
        return longarr;
    }
}
