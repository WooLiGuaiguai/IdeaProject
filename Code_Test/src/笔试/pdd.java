package 笔试;

import java.util.Scanner;

public class pdd {
    private static int [][]directions={{-1,0},{0,-1},{1,0},{0,1}};
    private static int m=0,n=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();//行数
        int M=sc.nextInt();//列数
        int [][]grids=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                grids[i][j]=sc.nextInt();
            }
        }
        System.out.println(maxAreaOfIsland(grids));
    }
    public static int maxAreaOfIsland(int [][]grids){
        if(grids==null||grids.length==0||grids[0].length==0){
            return 0;
        }
        n=grids.length;
        m=grids[0].length;
        int area=0;//面积
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grids[i][j]==0){
                    grids[i][j]=1;
                    for(int k=0;k<n;k++){
                        for(int l=0;l<m;l++){
                            if(k==i&&l==j){
                                continue;
                            }
                            if(grids[k][l]==0){
                                continue;
                            }
                            grids[k][l]=0;
                            area=Math.max(area,DFS_area(grids,i,j));
                            grids[k][l]=1;
                        }
                    }
                    grids[i][j]=0;
                }else{
                    area=Math.max(area,DFS_area(grids,i,j));
                }
            }
        }
        return area;
    }
    public static int DFS_area(int [][]grids,int i,int j){
        if(i<0||i>=n ||j<0||j>=m||grids[i][j]==0){
            return 0;
        }
        int cur_area=1;
        grids[i][j]=0;
        for (int[] direction : directions) {
            int nexti=i+direction[0];
            int nextj=j+direction[1];
            cur_area=cur_area+DFS_area(grids,nexti,nextj);
        }
        return  cur_area;
    }
    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//表示阶数
        int [][]result=new int[n][n];
        if(n%2==0){//偶数阶
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(j==i ||j==n-1-i){
                        result[i][j]=0;
                    }else if(j>=n/2 && j<n-1-i){
                        result[i][j]=1;
                    }else if(j>i && j<n/2){
                        result[i][j]=2;
                    }else if(i<n/2 && j<i ){
                        result[i][j]=3;
                    }else if(i>=n/2 && j<n-1-i ){
                        result[i][j]=4;
                    }else if(i>=n/2 &&j<n/2&& j>n-1-i ){
                        result[i][j]=5;
                    }else if(i>=n/2 && j<i ){
                        result[i][j]=6;
                    }else if(i>=n/2 && j>i ){
                        result[i][j]=7;
                    }else if(i<=n/2 && j>n-1-i ){
                        result[i][j]=8;
                    }
                }
            }
        }else{
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(j==i ||j==n-1-i||j==n/2||i==n/2){
                        result[i][j]=0;
                    }else if(j>n/2 && j<n-1-i){
                        result[i][j]=1;
                    }else if(j>i && j<n/2){
                        result[i][j]=2;
                    }else if(i<n/2 && j<i ){
                        result[i][j]=3;
                    }else if(i>n/2 && j<n-1-i ){
                        result[i][j]=4;
                    }else if(i>=n/2 &&j<n/2&& j>n-1-i ){
                        result[i][j]=5;
                    }else if(i>n/2 && j<i ){
                        result[i][j]=6;
                    }else if(i>n/2 && j>i ){
                        result[i][j]=7;
                    }else if(i<n/2 && j>n-1-i ){
                        result[i][j]=8;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }*/
}
