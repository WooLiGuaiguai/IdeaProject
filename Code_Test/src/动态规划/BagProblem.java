package 动态规划;

public class BagProblem {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,5,11}));
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
        System.out.println(coinChange(new int[]{1,2,5},11));
        System.out.println(change(5,new int[]{1,2,5}));
    }
    //换零钱的硬币数组合
    public static int change(int amount, int[] coins) {
        if(coins==null){//不考虑amount==0 因为change(0,{})应该返回1
            return  0;
        }
        int []dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i]=dp[i]+dp[i-coin];
            }
        }
        return dp[amount];
    }
    //换零钱的最少硬币数
    public static int coinChange(int []coins,int amount){
        if(amount<1)return 0;
        int []count=new int[amount+1];//用来存储组成每个值的最少硬币值
        return coinChange(coins,amount,count);
    }
    public static int coinChange(int []coins,int amount,int []count){
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        if(count[amount]!=0){//如果组成amount的最少硬币数求出来了  那么返回就行了
            return count[amount];
        }
        int min=Integer.MAX_VALUE;
        for(int coin:coins){
            int res=coinChange(coins,amount-coin,count);
            if(res>=0&&res<min){
                min=1+res;
            }
        }
        count[amount]=(min==Integer.MAX_VALUE)?-1:min;
        return count[amount];
    }
    public static int findMaxForm(String[] strs, int m, int n){
        if(strs==null||strs.length==0){
            return 0;
        }
        int [][]dp=new int[m+1][n+1];
        for(String str:strs){//逐步遍历字符串数组
            int ones=0,zeros=0;
            char []chars=str.toCharArray();
            //先获取资源数 也就是0和1的个数
            for (char aChar : chars) {
                if(aChar=='0'){
                    zeros++;
                }else{
                    ones++;
                }
            }
            for(int i=m;i>=0;i--){
                for(int j=n;j>=0;j--){
                    if(i>=zeros&&j>=ones){
                        dp[i][j]=Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }
    public static int findTargetSumWays(int[] nums, int S){
        int sum=computeArraySum(nums);
        if(sum<S||(S+sum)%2!=0){
            return 0;
        }
        int target=(sum+S)/2;
        int []dp=new int[target+1];
        dp[0]=1;
        for(int num:nums){
            for(int i=target;i>=0;i--){
                if(i>=num){
                    dp[i]=dp[i]+dp[i-num];
                }
            }
        }
        return dp[target];
    }
    //将数组划分为相同的部分 等价于 像一个背包中放数，保证所放的数和是所有数之和的一半
    //首先获取这个限制性的和,如果是奇数，那么题目无法满足
    //其次定义一个数组  dp[i]表示原数组是否可以取出若干个数字，其和为i
    //进行数组遍历,需要注意数组中的数只有小于目标时才有可能被添加进来
    //同时如果 dp[i - num]为true的话，说明现在已经可以组成 i-num 这个数字了，再加上num，就可以组成数字i了，那么dp[j]就一定为true。
    //如果之前dp[j]已经为true了，当然还要保持true，所以还要‘或’上自身
    //最后返回dp[target] 判断能否组成这个数字即可
    public static boolean canPartition(int[] nums){
        int sum = computeArraySum(nums);
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        boolean [] dp=new boolean[target+1];
        dp[0]=true;
        for(int num:nums){
            for(int i=target;i>=1;i--){
                if(i>=num){
                    dp[i]=dp[i]||dp[i-num];
                }
            }
        }
        return dp[target];
    }
    private static int computeArraySum(int [] nums){
        int sum=0;
        for (int num : nums) {
            sum=sum+num;
        }
        return sum;
    }
}
