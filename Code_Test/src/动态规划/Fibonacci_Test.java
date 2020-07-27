package 动态规划;

public class Fibonacci_Test {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
        System.out.println(rob(new int []{ 2,7,9,3,1}));
        System.out.println(rob2(new int[]{1,2,3,1}));
        System.out.println(errorNum(2));
        System.out.println(cowNew(7));//13
    }
    //5. 母牛生产 求第n年母牛总数
    //假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。
    //每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
    public static int cowNew(int n){
        if(n<=0){
            return 0;
        }
        int []dp=new int[n+1];
        dp[1]=1;dp[2]=2;dp[3]=3;dp[4]=4;//前四年母牛数量
        switch (n){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                for(int i=5;i<=n;i++) {
                    dp[i] = dp[i - 1] + dp[i - 3];//第i年的数量是前一年的数量加上三年前产出来的刚成熟后生出来的
                }
            }
        return dp[n];
    }
    //4. 信件错排
    //题目描述：有 N 个 信 和 信封，它们被打乱，求错误装信方式的数量。
    //定义一个数组 dp 存储错误方式数量，dp[i] 表示前 i 个信和信封的错误方式数量。
    // 假设第 i 个信装到第 j 个信封里面，而第 j 个信装到第 k 个信封里面。根据 i 和 k 是否相等，有两种情况：
    //i==k，交换 i 和 j 的信后，它们的信和信封在正确的位置，但是其余 i-2 封信有 dp[i-2] 种错误装信的方式。
    //      由于 j 有 i-1 种取值，因此共有 (i-1)*dp[i-2] 种错误装信方式。
    //i != k，交换 i 和 j 的信后，第 i 个信和信封在正确的位置，其余 i-1 封信有 dp[i-1] 种错误装信方式。
    //      由于 j 有 i-1 种取值，因此共有 (i-1)*dp[i-1] 种错误装信方式。
    public static int errorNum(int n){
        if(n==0||n==1){
            return 0;
        }
        if(n==2){return 1;}
        int []dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=(i-1)*(dp[i-1]+dp[i-2]);
        }
        return dp[n];
    }
    //3. 环形抢劫 也就是第一个和最后一个不能同时抢劫  213
    public static int rob2(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob_2(nums,0,nums.length-2),rob_2(nums,1,nums.length-1));
    }
    public static int rob_2(int []nums,int start,int end){
        int first=0,second=0;
        for(int i=start;i<=end;i++){
            int cur=Math.max(first+nums[i],second);
            first=second;
            second=cur;
        }
        return second;
    }
    //2.抢劫 设抢劫第i个用户时的最大抢劫量dp[i]   那么dp[i]=max(dp[i-2]+nums[i),dp[i-1])
    public static int rob(int[] nums) {
        int first=0,second=0;//first表示dp[i-2]  second表示dp[i-1]
        for(int i=0;i<nums.length;i++){
            int cur=Math.max(first+nums[i],second);
            first=second;
            second=cur;
        }
        return second;
    }
    //1.跳楼梯
    public static int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int []dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
