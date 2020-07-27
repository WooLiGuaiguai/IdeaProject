package 数组和矩阵;

public class 改变数组的维数 {
    public static void main(String[] args) {
        int [][]arr=matrixReshape(new int[][]{{1,2},{3,4}},1,4);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m=nums.length;
        int n=nums[0].length;
        if(m*n<r*c){
            return nums;
        }
        int [][]newMatrix=new int[r][c];
        int index=0;//标记下标
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                newMatrix[i][j]=nums[index/n][index%n];//遍历数组中的元素index/n为行  index%n为列
                index++;
            }
        }
        return newMatrix;
    }
}
