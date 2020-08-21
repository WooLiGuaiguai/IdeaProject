package 动态规划.数组区间;
//给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
public class 数组区间和 {
    private int[]dp;
    public 数组区间和(int[] nums){
        dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i=1;i<=nums.length;i++){
            dp[i]=dp[i-1]+nums[i];
        }
    }
    public static void main(String[] args) {

    }
    public int sumRange(int i, int j){
        return dp[j]-dp[i-1];
    }
}

