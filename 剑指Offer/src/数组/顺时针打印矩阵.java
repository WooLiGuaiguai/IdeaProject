package 数组;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    public static ArrayList<Integer> printMatrix(int [][] matrix){
        ArrayList<Integer> list=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return list;
        }
        int row=matrix.length-1,col=matrix[0].length-1;//表示当前遍历这圈的边界行列号
        int r=0,c=0;//表示当前的行和列号
        while(r<=row && c<=col){
            for(int j=c;j<=col;j++){
                list.add(matrix[r][j]);
            }
            for(int i=r+1;i<=row;i++){
                list.add(matrix[i][col]);
            }
            if(r!=row){
                //向左 有可能出现特殊的情况只有一行，为了避免重复访问
                for(int j=col-1;j>=c;j--){
                    list.add(matrix[row][j]);
                }
            }
            if(c!=col){
                for(int i=row-1;i>r;i--){
                    list.add(matrix[i][c]);
                }
            }
            r++;c++;
            row--;col--;
        }
        return list;
    }

    public static void main(String[] args) {
        int [][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(printMatrix(matrix));
    }
}
