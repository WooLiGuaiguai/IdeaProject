package 笔试;

import 查找.DFS;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class MeiTuan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        int [][]input=new int[n-1][2];
        for(int i=0;i<n-1;i++){
            input[i][0]=sc.nextInt();
            input[i][1]=sc.nextInt();
        }
        //构造图
        int [][]matrix=new int[n][n];
        for(int i=0;i<n-1;i++){
            matrix[input[i][0]][input[i][1]]=1;
            matrix[input[i][1]][input[i][0]]=1;
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(x);
        while(!stack.isEmpty()){
            int start=stack.pop();
            for(int i=1;i<=matrix.length;i++){
                if(i!=start && i!=y &&matrix[start-1][i-1]==1){
                    stack.push(i);
                }
            }
        }



    }
    public static void back(boolean []help,int x,int y,int [][]matrix){
        if(help[x-1]){//被访问过
            return;
        }
        help[x-1]=true;
        for(int i=1;i<=matrix.length;i++){
            /*if(help[i-1]==0 && i!=x && i!=y &&matrix[x-1][i-1]==1){
                //如果没有被访问，并且这个点不是小美所在的点，不是自身并且可达
                count++;
                DFS(help,i,y,matrix);
            }*/
        }
    }

}
