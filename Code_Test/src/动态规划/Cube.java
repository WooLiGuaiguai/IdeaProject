package 动态规划;

import java.util.Arrays;

public class Cube {
    public static void main(String[] args) {
        int [][]grid={{1,3,1},{1,5,1}, {4,2,1}};
        System.out.println(minPathSum1(grid));
    }
    //2.机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”） 问总共有多少条不同的路径？ 62
    public int uniquePaths(int m, int n) {
        int []dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j]=dp[j]+dp[j-1];//使用一维数组保存的意义在于将上一层的dp[j]和这一层的dp[j-1]相加
            }
        }
        return dp[n-1];
    }
    //1.给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //说明：每次只能向下或者向右移动一步。  64
    //新建一个额外的dp数组，与原矩阵大小相同。在这个矩阵中，dp(i, j)表示从坐标(i,j)到右下角的最小路径权值。
    //初始化右下角的 dp值为对应的原矩阵值，然后去填整个矩阵，对于每个元素考虑移动到右边或者下面，因此获得最小路径递推公式：
    //dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))
    public static int minPathSum(int[][] grid) {//二维数组实现动态规划
        if(grid==null||grid.length==0){
            return 0;
        }
        int [][]dp=new int[grid.length][grid[0].length];
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(i==grid.length-1 && j!=grid[0].length-1){//向左移动 当前结点到末点的最短距离直接就是右边结点的dp值+当前矩阵值
                    dp[i][j]=grid[i][j]+dp[i][j+1];
                }else if(i!=grid.length-1 && j==grid[0].length-1){//同理向上移动
                    dp[i][j]=grid[i][j]+dp[i+1][j];
                }else if(i!=grid.length-1 && j!=grid[0].length-1){
                    dp[i][j]=grid[i][j]+Math.min(dp[i][j+1],dp[i+1][j]);
                }else {
                    dp[i][j]=grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
    public static int minPathSum1(int[][] grid) {//一维数组实现动态规划
        if(grid==null||grid.length==0){
            return 0;
        }
        int []dp=new int[grid[0].length];
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(i==grid.length-1 && j!=grid[0].length-1){//向左移动 当前结点到末点的最短距离直接就是右边结点的dp值+当前矩阵值
                    dp[j]=grid[i][j]+dp[j+1];
                }else if(i!=grid.length-1 && j==grid[0].length-1){//同理向上移动
                    dp[j]=grid[i][j]+dp[j];
                }else if(i!=grid.length-1 && j!=grid[0].length-1){
                    dp[j]=grid[i][j]+Math.min(dp[j+1],dp[j]);
                }else {
                    dp[j]=grid[i][j];
                }
            }
        }
        return dp[0];
    }
}
