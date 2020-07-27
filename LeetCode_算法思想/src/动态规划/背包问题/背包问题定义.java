package 动态规划.背包问题;
//问题变种：
//完全背包：物品数量为无限个
//多重背包：物品数量有限制
//多维费用背包：物品不仅有重量，还有体积，同时考虑这两种限制
//其它：物品之间相互约束或者依赖
public class 背包问题定义 {
    /*有一个容量为 N 的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积 w 和价值 v。
    定义一个二维数组 dp 存储最大价值，其中 dp[i][j] 表示前 i 件物品体积不超过 j 的情况下能达到的最大价值。
    设第 i 件物品体积为 w，价值为 v，根据第 i 件物品是否添加到背包中，可以分两种情况讨论：
    第 i 件物品没添加到背包，总体积不超过 j 的前 i 件物品的最大价值就是总体积不超过 j 的前 i-1 件物品的最大价值，dp[i][j] = dp[i-1][j]。
    第 i 件物品添加到背包中，dp[i][j] = dp[i-1][j-w] + v。
    第 i 件物品可添加也可以不添加，取决于哪种情况下最大价值更大。*/
    public int knapsack(int W, int N, int[] weights, int[] values){
        int [][]dp=new int[N+1][W+1];
        for(int i=1;i<=N;i++){
            int w=weights[i-1],v=values[i-1];//表示第i件物品的体积和价值
            for(int j=1;j<=W;j++){
                if(j>=w){//j表示物件体积不能超过的最大值
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                }else{//如果超过了 第i件物品就不能添加进来
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }
    //空间优化
    //在程序实现时可以对 0-1 背包做优化。观察状态转移方程可以知道，前 i 件物品的状态仅与前 i-1 件物品的状态有关
    //因此可以将 dp 定义为一维数组，其中 dp[j] 既可以表示 dp[i-1][j] 也可以表示 dp[i][j]
    //因为 dp[j-w] 表示 dp[i-1][j-w]，因此不能先求 dp[i][j-w]，防止将 dp[i-1][j-w] 覆盖。
    //先计算 dp[i][j] 再计算 dp[i][j-w]，在程序实现时需要按倒序来循环求解。
    public int knapsack2(int W, int N, int[] weights, int[] values){
        int []dp=new int[W+1];
        for(int i=1;i<=N;i++){
            int w=weights[i-1],v=values[i-1];//表示第i件物品的体积和价值
            for(int j=W;j>=0;j--){
                if(j>=w){
                    dp[j]=Math.max(dp[j],dp[j-w]+v);
                }
            }
        }
        return dp[W];
    }
}
