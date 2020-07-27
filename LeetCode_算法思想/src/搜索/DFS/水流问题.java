package 搜索.DFS;
//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
//规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
//请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
//  太平洋 ~   ~   ~   ~   ~
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//返回:
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 水流问题 {
    public static void main(String[] args) {
        int [][]matrix={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,5,4}};
        System.out.println(pacificAtlantic(matrix));
    }
    private static int m,n;//表示矩阵的长和宽
    private static int [][]directions={{-1,0},{0,-1},{1,0},{0,1}};
    public static List<List<Integer>> pacificAtlantic(int[][] matrix){
        List<List<Integer>> list=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return list;
        }
        m=matrix.length;
        n=matrix[0].length;
        boolean [][]canreachP=new boolean[m][n];//能否到太平洋
        boolean [][]canreachA=new boolean[m][n];//能否到大西洋
        //可以从边界开始回溯
        for(int i=0;i<m;i++){//判断左边界可达太平洋的点和右边界可达大西洋的点  将点的canreach值设为true
            reach(canreachP,i,0,matrix);
            reach(canreachA,i,n-1,matrix);
        }
        for(int j=0;j<n;j++){
            reach(canreachP,0,j,matrix);
            reach(canreachA,m-1,j,matrix);
        }
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(canreachA[i][j]&&canreachP[i][j]){
                    //使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    public static void reach(boolean [][]canreach,int i,int j,int[][] matrix){
        if(canreach[i][j]){////上来并没有先判断是否出界  因为这里的出界意味着已经到达两大洋 是可达的 不必返回
            return;
        }
        canreach[i][j]=true;//标记被访问
        for (int[] direction : directions) {
            int nextI=i+direction[0];
            int nextJ=j+direction[1];
            if(nextI<0||nextI>=m||nextJ<0||nextJ>=n||matrix[i][j]>matrix[nextI][nextJ]){
                continue;//如果ij表示的元素大于nexti nextj表示元素 意味着(i,j)<-(nexti,nextj)不可达
            }
            //否则的话可达 以该点为源点 继续遍历
            reach(canreach,nextI,nextJ,matrix);
        }
    }
}
