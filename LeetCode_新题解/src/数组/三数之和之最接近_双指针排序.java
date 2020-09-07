package 数组;
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
//找出 nums 中的三个整数，使得它们的和与 target 最接近
//返回这三个数的和。假定每组输入只存在唯一答案。

import java.util.Arrays;

public class 三数之和之最接近_双指针排序 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len=nums.length;//存放数组的长度
        int best=10000000;//最好的和
        for(int i=0;i<len;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int curSum=nums[i];
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=curSum+nums[left]+nums[right];
                if(sum==target){//如果三数之和等于target  那么返回
                    return target;
                }
                //根据差值来对best和进行更新
                if(Math.abs(sum-target)<Math.abs(best-target)){
                    best=sum;
                }
                //然后确定怎样移动
                if(sum>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int []num={-1,2,1,-4};
        System.out.println(threeSumClosest(num,1));

    }

}
