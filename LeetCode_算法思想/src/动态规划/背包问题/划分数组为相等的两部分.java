package 动态规划.背包问题;

public class 划分数组为相等的两部分 {
    public static boolean canPartition(int[] nums){
        int sum=computeArraynums(nums);
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        boolean []dp=new boolean[target+1];//这里存放的是容积
        dp[0]=true;
        for (int i=1;i<nums.length;i++){// 0-1 背包一个物品只能用一次
            for (int j=target;j>=0;j--){// 从后往前，先计算 dp[i] 再计算 dp[i-num]
                if(j>=nums[i]){
                    dp[j]=dp[j]||dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
    public static int computeArraynums(int []nums){
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int []a={1,3,8,10};
        int []b={2,2,3,6};
        System.out.println(canPartition(a));
        System.out.println(canPartition(b));
    }
}
