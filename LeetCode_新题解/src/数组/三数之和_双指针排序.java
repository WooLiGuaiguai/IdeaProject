package 数组;
//给你一个包含 n 个整数的数组 nums
//判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
//请你找出所有满足条件且不重复的三元组。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和_双指针排序 {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> lists=new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]>0){
                return lists;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int leftNum=nums[i];
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=leftNum+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(leftNum);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    while(left<right && nums[left]==nums[left+1]){
                        left++;//中间这个数也要保持和之前的不相同
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;//右边这个数也要保持和之前的不相同
                    }
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return lists;
    }
    public static void main(String[] args) {
        int []nums={-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
