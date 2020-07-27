package 搜索.BFS;
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//示例 1:  输入: n = 12  输出: 3  解释: 12 = 4 + 4 + 4.
//示例 2:   输入: n = 13  输出: 2  解释: 13 = 4 + 9.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//这个题可以把每个数字当做是一个节点，然后使用BFS
//例如n=12  小于n的平方数有1 4 9,那么将12看做根结点，然后第二层节点分别是12-1 12-4 12-9，分别是减了一个1 一个4和一个9 所以步长是一样的
//需要注意的是我们也需要标记一个节点是否被访问了
public class 完全平方数 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    public static int numSquares(int n){
        List<Integer> squares=Squares(n);
        Queue<Integer>queue=new LinkedList<>();
        boolean []flag=new boolean[n+1];//为1-n设置标记值
        queue.add(n);
        int level=0;//步长数
        while(!queue.isEmpty()){
            int size=queue.size();
            level++;
            while(size-->0){
                int cur=queue.poll();//获取当前数值
                for (int square : squares) {
                    int next=cur-square;
                    if(next<0){//如果小于0 说明后面的square也会导致next小于0 直接退出循环
                        break;
                    }
                    if(next==0){
                        return level;
                    }
                    if(flag[next]){//被访问过了 那么就跳过这个square
                        continue;
                    }
                    flag[next]=true;
                    queue.add(next);
                }
            }
        }
        return n;//如果没找到 可以n个1组成
    }
    //返回小于等于n的完全平方数
    public static List<Integer> Squares(int n){//12
        int input=1;
        int add=3;
        List<Integer>list=new ArrayList<>();
        while(input<=n){
            list.add(input);//1 4 9
            input=input+add;//4 9 16  获取下一个完全平方数
            add=add+2;      //5 7 9
        }
        return list;
    }
}
