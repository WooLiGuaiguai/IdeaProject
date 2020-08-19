package 数组;

import java.util.Arrays;

public class 构建乘积数组 {
    public static int[] multiply(int[] A){
        int []result=new int[A.length];
        if (A==null||A.length==0){
            return result;
        }
        Arrays.fill(result,1);
        int left=1;//存储左边的乘积
        for(int i=1;i<result.length;i++){
            left=left*A[i-1];
            result[i]=result[i]*left;
        }
        int right=1;
        for(int i=A.length-2;i>=0;i--){
            right=right*A[i+1];
            result[i]=result[i]*right;
        }
        return result;
    }

    public static void main(String[] args) {
        int []nums={1,2,3,4};
        int [] arr=multiply(nums);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
