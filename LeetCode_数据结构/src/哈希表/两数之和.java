package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 两数之和 {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9};
        int []sum=twoSum(arr,8);
        for (int i : sum) {
            System.out.print(i+" ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();//前面存值 后面存序号
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
