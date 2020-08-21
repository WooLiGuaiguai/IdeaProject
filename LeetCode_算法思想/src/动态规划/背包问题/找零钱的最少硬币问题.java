package 动态规划.背包问题;
//给一些面额的硬币，要求用这些硬币来组成给定面额的钱数，并且使得硬币数量最少。硬币可以重复使用。
//
//物品：硬币
//物品大小：面额
//物品价值：数量
//因为硬币可以重复使用，因此这是一个完全背包问题。完全背包只需要将 0-1 背包的逆序遍历 dp 数组改为正序遍历即可。
public class 找零钱的最少硬币问题 {
    public static int coinChange(int[] coins, int amount) {
        //整体的思路是 首先使用一个硬币，对coin--amount之间的所有值用该硬币进行填充 求出每个dp值
        //然后换一枚新的硬币 对之前的数组进行更新 判断的是之前的dp[i]和 现在如果i使用当前coin填充获得的dp[i-coin] 之间的大小
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) { //将逆序遍历改为正序遍历
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;

                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int []coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));//3
        int []coins1 = {2};
        int amount1 = 3;
        System.out.println(coinChange(coins1,amount1));//-1
    }
}
