package 贪心算法;

public class 最大子序列和 {
    public static void main(String[] args) {
        int []nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        int presum=nums[0];
        int sum=nums[0];
        for (int i=1;i<nums.length;i++){
            presum=presum>=0?presum+nums[i]:nums[i];
            sum=Math.max(sum,presum);
        }
        return sum;
    }
}
