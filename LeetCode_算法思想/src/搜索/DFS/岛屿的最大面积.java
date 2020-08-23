package 搜索.DFS;
//给定一个包含了一些 0 和 1 的非空二维数组 grid 。
//一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
//你可以假设 grid 的四个边缘都被 0（代表水）包围着。
//找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
public class 岛屿的最大面积 {
    public static void main(String[] args) {
        int [][] grids={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grids));
    }
    private static int [][]directions={{-1,0},{0,-1},{1,0},{0,1}};
    private static int m=0,n=0;
    public static int maxAreaOfIsland(int[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        m= grid.length;
        n=grid[0].length;
        int area=0;//面积
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                area=Math.max(area,DFS_area(grid,i,j));//从(0,0)到下标(i,j)的连通面积最大值
            }
        }
        return area;
    }
    public static int DFS_area(int [][] grid,int i,int j){
        if(i<0||i>=m||j<0||j>=n||grid[i][j]==0){
            return 0;
        }
        //当前grid值为1
        int cur_area=1;
        grid[i][j]=0;//防止被再次访问
        for (int[] direction : directions) {
            cur_area+=DFS_area(grid,i+direction[0],j+direction[1]);
        }
        return cur_area;
    }
}
