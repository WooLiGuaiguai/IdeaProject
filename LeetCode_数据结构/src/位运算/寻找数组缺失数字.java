package 位运算;

public class 寻找数组缺失数字 {
    public static void main(String[] args) {
        int []ar={4,2,0,3};
        System.out.println(missingNumber(ar));
    }
    public static int missingNumber(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            n=n^i^nums[i];
        }
        return n;
    }
}
