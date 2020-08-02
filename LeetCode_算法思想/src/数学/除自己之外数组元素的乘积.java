package 数学;

import java.util.Arrays;

public class 除自己之外数组元素的乘积 {
    public static void main(String[] args) {
        int []nums={1,2,3,4};
        int [] arr=productExceptSelf(nums);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static int[] productExceptSelf(int[] nums) {//1 2 3 4
        int n=nums.length;
        int []produces=new int[n];
        Arrays.fill(produces,1);
        int left=1;
        for(int i=1;i<n;i++){//先给nums[i]计算出它最左侧的乘积
            left=left*nums[i-1];//1 2 6
            produces[i]=produces[i]*left;//1 1 2 6
        }
        int right=1;
        for(int i=n-2;i>=0;i--){
            right=right*nums[i+1];//24 12 4
            produces[i]=produces[i]*right;//24 12 8 6
        }
        return produces;
    }
}
