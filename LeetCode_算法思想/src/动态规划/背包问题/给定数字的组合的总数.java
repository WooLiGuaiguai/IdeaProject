package 动态规划.背包问题;

import java.util.Arrays;

//nums = [1, 2, 3]
//target = 4
//
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//
//请注意，顺序不同的序列被视作不同的组合。
public class 给定数字的组合的总数 {
    public static int combinationSum4(int[] nums, int target) {
        //可以反复选取 且顺序不同视作不同集合  相当于顺序的背包问题
        int []dp=new int[target+1];
        dp[0]=1;
        Arrays.sort(nums);
        for(int i=1;i<=target;i++){
            for (int num : nums) {
                if(num<=i){
                    dp[i]=dp[i]+dp[i-num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int []a={1,2,3};
        System.out.println(combinationSum4(a,4));
    }
}
