package 动态规划.矩阵路径;
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//说明：每次只能向下或者向右移动一步。
public class 最小路径和 {
    //利用动态规划的思想从右下角开始 逐行遍历，找到每个点到右下角的最小值
    public static int minPathSum(int[][] grid){
        if (grid==null||grid.length==0){
            return 0;
        }
        int [][]dp=new int[grid.length][grid[0].length];//标记最小值数组
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if (i==grid.length-1 && j!=grid[0].length-1){//最后一行
                    dp[i][j]=grid[i][j]+dp[i][j+1];
                }else if(i!=grid.length-1 && j==grid[0].length-1){//最后一列
                    dp[i][j]=grid[i][j]+dp[i+1][j];
                }else if(i!=grid.length-1 && j!=grid[0].length-1){
                    dp[i][j]=grid[i][j]+Math.min(dp[i][j+1],dp[i+1][j]);
                }else{
                    dp[i][j]=grid[i][j];//右下角结点
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int [][]grid={
                {1,3,1},
                {1,5,1},
                {4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
