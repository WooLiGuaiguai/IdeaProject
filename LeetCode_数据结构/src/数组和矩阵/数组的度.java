package 数组和矩阵;

import java.util.HashMap;

/*给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
*/
public class 数组的度 {
    public static void main(String[] args) {
        int []nums={1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));

    }
    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> countMap=new HashMap<>();//存储一个数字出现的次数
        HashMap<Integer,Integer> FirstIndex=new HashMap<>();//存储一个数字出现的第一次
        HashMap<Integer,Integer> LastIndex=new HashMap<>();//存储一个数字出现的最后一次
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            countMap.put(num,countMap.getOrDefault(num,0)+1);
            LastIndex.put(num,i);//每次更新最后一次出现的位置
            if(!FirstIndex.containsKey(num)){//如果没有这个key值意味着没有出现过
                FirstIndex.put(num,i);
            }
        }
        int maxcount=0;
        for (int num : nums) {//获取最大频数
            maxcount=Math.max(maxcount,countMap.get(num));
        }
        //找到最短的长度
        int minLen=Integer.MAX_VALUE;
        for (int num:nums){
            if(countMap.get(num)==maxcount){//找到出现频数符合要求的 计算它的子串长度
                minLen=Math.min(minLen,LastIndex.get(num)-FirstIndex.get(num)+1);
            }
        }
        return minLen;
    }
}
