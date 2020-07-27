package 查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//从一个节点出发，使用 DFS 对一个图进行遍历时，能够遍历到的节点都是从初始节点可达的，DFS 常用来求解这种 可达性 问题。
//在程序实现 DFS 时需要考虑以下问题：
//栈：用栈来保存当前节点信息，当遍历新节点返回时能够继续遍历当前节点。可以使用递归栈。
//标记：和 BFS 一样同样需要对已经遍历过的节点进行标记。
public class DFS {
    private static int m,n;//表示矩阵的长和宽
    private static int [][]directions={{-1,0},{0,-1},{1,0},{0,1}};
    public static void main(String[] args) {
        int[][] S = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        char [][] chars={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int [][]friend={{1,1,0},{1,1,0},{0,0,1}};
        char [][]board={{'X','X','X','X'},
                        {'X','O','O','X'},
                        {'X','X','O','X'},
                        {'X','O','O','X'}};
        int [][]Ocean={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(maxAreaOfIsland(S));
        System.out.println(numIslands(chars));
        System.out.println(findCircleNum(friend));
        solve(board);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    //5. 太平洋大西洋水流问题 417
    //这道题的意思是返回一个集合，这个集合中每个坐标的处的水能够满足同时到达大西洋和太平洋
    //想法是使用两个boolean数组 从边界往回找 可达的路径上每个坐标处值都是T  最终两个数组一个坐标处的值同时为T 符合要求
    private  int[][] matrix;
    public  List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> Lists=new ArrayList<>();
        if(matrix==null||matrix.length==0){
            return Lists;
        }
        m=matrix.length;
        n=matrix[0].length;
        this.matrix = matrix;
        boolean [][] canReachP=new boolean[m][n];
        boolean [][] canReachA=new boolean[m][n];
        for(int i=0;i<m;i++){
            DFS_reach(canReachP,i,0);//遍历第一列 查找可达的是P
            DFS_reach(canReachA,i,n-1);//遍历最后一列 查找可达的是A
        }
        for(int i=0;i<n;i++){
            DFS_reach(canReachP,0,i);//遍历第一行 查找可达的是P
            DFS_reach(canReachA,m-1,i);//遍历最后一行 查找可达的是A
        }
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(canReachA[i][j]&&canReachP[i][j]){
                    //使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法
                    Lists.add(Arrays.asList(i,j));
                }
            }
        }
        return Lists;
    }
    public void DFS_reach(boolean[][] reach,int i,int j){
        if(reach[i][j]){//上来并没有先判断是否出界  因为这里的出界意味着已经到达两大洋 是可达的 不必返回
            return;
        }
        reach[i][j]=true;//标记上被访问
        for(int []direction:directions){
            int nextI=i+direction[0];
            int nextJ=j+direction[1];
            if(nextI<0||nextI>=m||nextJ<0||nextJ>=n||matrix[i][j]>matrix[nextI][nextJ]){
                continue;//如果越界或者ij表示的元素大于nexti nextj表示元素 意味着(i,j)<-(nexti,nextj)不可达
            }
            DFS_reach(reach,nextI,nextJ);
        }
    }
    //4. 被围绕的区域进行填充 130
    public static void solve(char[][] board){
        if(board==null||board.length==0){
            return;
        }
        m=board.length;
        n=board[0].length;
        //遍历边界
        for(int i=0;i<m;i++){
            DFS_change(board,i,0);
            DFS_change(board,i,n-1);
        }
        for(int i=0;i<n;i++){
            DFS_change(board,0,i);
            DFS_change(board,m-1,i);
        }
        //将T转化成O  实现边界无连接包围的O转化成X
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    public static void DFS_change(char [][]board,int i,int j){
        if(i<0||i>=m||j<0||j>=n||board[i][j]!='O'){
            return;
        }
        board[i][j]='T';
        for (int[] direction : directions) {
            DFS_change(board,i+direction[0],j+direction[1]);
        }
    }
    //3. 好友关系的连通分量数目 547
    public static int findCircleNum(int[][] M){
        m=M.length;
        int friend_circle=0;//朋友圈数量
        boolean []hasvisit=new boolean[m];
        for(int i=0;i<m;i++){
            if(!hasvisit[i]){//如果他没有被访问 查找他的所有朋友节点 标记为已访问
                DFS_findfri(M,i,hasvisit);
                friend_circle++;//一个节点和他的所有朋友在 一个朋友圈
            }
        }
        return friend_circle;
    }
    public static void DFS_findfri(int [][]M,int i,boolean[]hasvisit){
        hasvisit[i]=true;
        for(int j=0;j<M.length;j++){
            if(M[i][j]==1&&!hasvisit[j]){//如果两者有朋友关系 并且没有被访问到
                DFS_findfri(M,j,hasvisit);
            }
        }
    }
    //2. 矩阵中的连通分量数目 200
    public static int numIslands(char[][] grid){
        if(grid==null||grid.length==0){
            return 0;
        }
        m=grid.length;
        n=grid[0].length;
        int num=0;//确定数量
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!='0'){//当前是1  遍历找到所有与之相连接的点 连通分量数+1
                    DFS_num(grid,i,j);
                    num++;
                }
            }
        }
        return num;
    }
    public static void DFS_num(char [][]grid,int i,int j){
        if(i<0||i>=m||j<0||j>=n||grid[i][j]=='0'){
            return ;
        }
        grid[i][j]='0';
        for (int[] direction : directions) {
            DFS_num(grid,i+direction[0],j+direction[1]);
        }
    }
    //1. 查找最大的连通面积   695
    public static int maxAreaOfIsland(int[][] grid){
        if(grid==null||grid.length==0){
            return 0;
        }
        m=grid.length;
        n=grid[0].length;
        int area=0;//表示面积
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                area=Math.max(area,DFS_area(grid,i,j));
            }
        }
        return area;
    }
    public static int DFS_area(int[][] grid,int i,int j){
        if(i<0||i>=m||j<0||j>=n||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;//到了这一步意味着原来是1 防止被再次访问 设成0
        int cur_area=1;//意味着面积从1开始
        for(int []dir:directions){
            cur_area+=DFS_area(grid,i+dir[0],j+dir[1]);
        }
        return cur_area;
    }
}
