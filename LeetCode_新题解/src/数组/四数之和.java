package 数组;
//给定一个包含 n 个整数的数组 nums 和一个目标值 target
//判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
//找出所有 满足条件且不重复 的四元组。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists=new ArrayList<>();
        if(nums==null||nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<len;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1,right=len-1;
                while(left<right){
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while (left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int []nums = {1, 0, -1, 0, -2, 2};
        int []num2={0,0,0,0};
        int []num3={-1,0,1,2,-1,-4};
        System.out.println(fourSum(nums,0));
        System.out.println(fourSum(num2,0));
        System.out.println(fourSum(num3,-1));
    }
}
