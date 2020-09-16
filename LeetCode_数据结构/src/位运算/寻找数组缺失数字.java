package 位运算;
//由于异或运算（XOR）满足结合律，并且对一个数进行两次完全相同的异或运算会得到原来的数
//数组中有 n 个数，并且缺失的数在 [0..n]中。可以先得到 [0..n]的异或值，再将结果对数组中的每一个数进行一次异或运算。
//未缺失的数在 [0..n] 和数组中各出现一次，因此异或后得到 0。
//而缺失的数字只在 [0..n] 中出现了一次，在数组中没有出现，因此最终的异或结果即为这个缺失的数字

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
