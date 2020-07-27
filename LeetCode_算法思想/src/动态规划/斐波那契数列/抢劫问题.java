package 动态规划.斐波那契数列;

public class 抢劫问题 {
    //抢劫的房子是环状连接的
    public static int rob2(int[] nums){
        //这样考虑 假设一个点序号为0，那么不管是奇数个还是偶数个点，只要遍历的时候遍历到nums.length-2就可以了
        //同时从序号1开始遍历到nums.length-1 两者作比较就是最终结果
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob_2(nums,0,nums.length-2),rob_2(nums,1,nums.length-1));
    }
    public static int rob_2(int []nums,int start,int end){
        int first=0,second=0;
        for(int i=start;i<=end;i++){
            int curMax=Math.max(first+nums[i],second);
            first=second;
            second=curMax;
        }
        return second;
    }
    //抢劫的房子是串行的数组
    public static int rob(int[] nums){
        int first=0,second=0;
        for (int i=0;i<nums.length;i++){
            int curMax=Math.max(first+nums[i],second);//0 0 nums[0] nums[1]
            first=second;
            second=curMax;
        }
        return second;
    }

    public static void main(String[] args) {

    }
}
