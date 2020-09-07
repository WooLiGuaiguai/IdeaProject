package 笔试;

public class BiliBili {
    public static void main(String[] args) {
        int [][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int []result=SpiralMatrix(matrix);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
        int []arr={1,1,1,0,0,0,1,1,1,1,1};
        System.out.println(longestOnes(arr,2));
    }
    public static int[] SpiralMatrix(int [][]matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return null;
        }
        int row=matrix.length-1,col=matrix[0].length-1;//表示当前遍历这圈的边界行列号
        int []result=new int[matrix.length*matrix[0].length];
        int r=0,c=0;//表示当前的行和列号
        int index=0;
        while(r<=row && c<=col){
            for(int j=c;j<=col;j++){
                result[index]=matrix[r][j];
                index++;
            }
            for(int i=r+1;i<=row;i++){
                result[index]=matrix[i][col];
                index++;
            }
            if(r!=row){
                for(int j=col-1;j>=c;j--){
                    result[index]=matrix[row][j];
                    index++;
                }
            }
            if(c!=col){
                for(int i=row-1;i>r;i--){
                    result[index]=matrix[i][c];
                    index++;
                }
            }
            r++;c++;
            row--;col--;
        }
        return result;
    }
    public static int longestOnes (int[]A, int K) {
        int left = 0, right = 0;
        int max = 0;
        int zero = 0;
        while (right != A.length) {
            if (A[right++] == 0) {
                zero++;
            }
            //判定条件，0的个数大于K
            while (zero > K) {
                if (A[left++] == 0) {
                    --zero;
                }
            }
            int count = right - left;
            max = max > count ? max : count;
        }
        return max;
    }
}
