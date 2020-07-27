package 贪心算法;

public class GA8 {
    public static void main(String[] args) {
        int []a={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }
    public static int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int max=nums[0];
        int pre=nums[0];
        for(int i=1;i<nums.length;i++){
            pre=pre>0?pre+nums[i]:nums[i];
            max=Math.max(max,pre);
        }
        return max;
    }
}
