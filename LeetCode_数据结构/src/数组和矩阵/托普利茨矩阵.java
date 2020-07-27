package 数组和矩阵;
/*如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
输出: True */
public class 托普利茨矩阵 {
    public static void main(String[] args) {
        int [][]matrix = { {1,2,3,4},
                           {5,1,2,3},
                           {9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }
    public static boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        //首先从矩阵的列开始遍历
        for(int i=0;i<matrix[0].length;i++){
            int value=matrix[0][i];
            if(!check(matrix,value,0,i)){
                return false;
            }
        }
        //然后从行开始遍历
        for(int i=0;i<matrix.length;i++){
            int value=matrix[i][0];
            if(!check(matrix,value,i,0)){
                return false;
            }
        }
        return true;
    }
    public static boolean check(int [][]matrix,int value,int row,int col){
        if(row>=matrix.length||col>=matrix[0].length){
            return true;
        }
        if(matrix[row][col]!=value){
            return false;
        }
        return check(matrix,value,row+1,col+1);
    }
}
