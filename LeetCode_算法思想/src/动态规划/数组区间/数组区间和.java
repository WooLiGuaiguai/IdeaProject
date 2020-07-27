package 动态规划.数组区间;

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

