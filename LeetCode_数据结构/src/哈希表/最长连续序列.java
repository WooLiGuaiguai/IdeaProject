package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class 最长连续序列 {
    public static void main(String[] args) {
        int []arr={100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }
    //最长连续序列 意味着从当前num开始，是否有与它连续的数字出现。
    //那么如果使用num作为key，相应的value应该存储的是以num为起点的最长字符串长度
    public static int longestConsecutive(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int Maxlength=0;//最长长度
        //初始化这个映射关系
        for (int num : nums) {
            map.put(num,1);
        }
        //更新映射关系
        for (int num : nums) {
            nextLength(map,num);
        }
        for (int key : map.keySet()) {
            Maxlength=Math.max(Maxlength,map.get(key));
        }
        return Maxlength;
    }
    public static int nextLength(Map<Integer,Integer> map,int num){
        if(!map.containsKey(num)){//如果不包含数字直接返回0
            return 0;
        }
        int length=map.get(num);
        if(length>1){//意味着已经更新过了
            return length;
        }
        length=nextLength(map,num+1)+1;//更新长度
        map.put(num,length);
        return length;
    }
}
