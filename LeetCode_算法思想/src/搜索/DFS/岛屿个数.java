package 搜索.DFS;
//岛屿个数也就是图的连通分量个数
public class 岛屿个数 {
    public static void main(String[] args) {
        char [][]grid={
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','0','0','0','0'},
                {'0','1','0','1','0'}};
        System.out.println(numIslands(grid));
    }
    private static int m,n;//表示矩阵的长和宽
    private static int [][]directions={{-1,0},{0,-1},{1,0},{0,1}};
    public static int numIslands(char[][] grid){
        if (grid==null|grid.length==0||grid[0].length==0){
            return 0;
        }
        m=grid.length;
        n=grid[0].length;
        int count=0;//连通分量个数
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    DFS_isArea(grid,i,j);//把与之相连的整个连通分量设为0
                    count++;
                }
            }
        }
        return count;
    }
    public static  void DFS_isArea(char[][] grid,int i,int j){
        if(i<0||i>=m||j<0||j>=n||grid[i][j]=='0'){
            return;//不符合要求直接就返回了
        }
        grid[i][j]='0';
        for (int[] direction : directions) {
            DFS_isArea(grid,i+direction[0],j+direction[1]);
        }
    }
}
