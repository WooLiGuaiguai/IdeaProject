package 数组和矩阵;
/*编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。*/
public class 高效搜索二维数组 {
    public static void main(String[] args) {

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int r=0,c=n-1;//从第一行最后一个 数字开始遍历
        while(r<m&&c>=0){//因为从右上角遍历 所以r会不断增大，c会不断缩小
            if(matrix[r][c]>target){
                c--;
            }else if(matrix[r][c]<target){
                r++;
            }else{
                return true;
            }
        }
        return false;
    }
}
