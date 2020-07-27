package 搜索.BFS;
//在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
//一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
//相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
//C_1 位于 (0, 0)（即，值为 grid[0][0]）
//C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
//如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
//返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class 计算在网格中从原点到特定点的最短路径长度 {
    public static void main(String[] args) {
        int [][]grids={{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grids));//4
    }

    public static int shortestPathBinaryMatrix(int[][] grids) {
        //最短路径问题  使用BFS
        if(grids==null||grids.length==0||grids[0].length==0){
            return -1;
        }
        //确定方向数组
        int[][] direction={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        //因为横纵坐标都有用，所以使用Pair键值对来进行存储
        Queue<Pair<Integer,Integer>> queue=new LinkedList<>();
        int m=grids.length,n=grids[0].length;//确定矩阵的长和宽
        queue.add(new Pair<>(0,0));//第一个元素进队列
        int length=0;//作为最终的返回长度
        while(!queue.isEmpty()){
            int size=queue.size();
            length++;//每遍历一层 意味着长度加一  所以length应该在此处++
            while(size>0){
                Pair<Integer,Integer> pair=queue.poll();
                size--;
                int x=pair.getKey(),y=pair.getValue();
                if(grids[x][y]==1){//被访问或阻塞
                    continue;
                }
                if(x==m-1 && y==n-1){//到达最终结点 返回长度
                    return length;
                }
                grids[x][y]=1;//进行访问
                for(int []dir:direction){
                    int x_new=x+dir[0];
                    int y_new=y+dir[1];
                    if(x_new<0||x_new>=m||y_new<0||y_new>=n){
                        continue;
                    }
                    queue.add(new Pair<>(x_new,y_new));
                }
            }
        }
        return -1;
    }
}
