package 动态规划.背包问题;

public class 目标和 {
    public static void main(String[] args) {
        int []nums={1, 1, 1, 1, 1};
        int S= 3;
        int []a={0,0,0,0,0,0,0,0,1};
        System.out.println(findTargetSumWays(a,1));
        System.out.println(findTargetSumWays(nums,S));
    }
    //改变一组数的正负号使得它们的和为一给定数  返回改变的方法有几种

    //该问题可以转换为 Subset Sum 问题，从而使用 0-1 背包的方法来求解。
    //可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
    //                  sum(P) - sum(N) = target
    //sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    //                       2 * sum(P) = target + sum(nums)
    //因此找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
    public static int findTargetSumWays(int[] nums, int S){
        int sum=computeArraynums(nums);
        if(sum<S||(S+sum)%2!=0){
            return 0;
        }
        int W=(S+sum)/2;
        int []dp=new int[W+1];
        dp[0]=1;
        for (int num : nums) {
            for(int j=W;j>=0;j--){
                if(j>=num){
                    dp[j]=dp[j]+dp[j-num];
                }
            }
        }
        return dp[W];
    }
    public static int computeArraynums(int []nums){
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        return sum;
    }
}
