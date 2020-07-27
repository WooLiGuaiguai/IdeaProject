package 动态规划.子序列;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int []nums={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        int []dp=new int[nums.length];//保存的是以nums[i]处的数字结尾的最长字符串
        for(int i=0;i<nums.length;i++){
            int maxlen=1;//如果出现了非递增序列 重新开始 这时候长度为1 只有当前结点
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    maxlen=Math.max(maxlen,dp[j]+1);
                }
            }
            dp[i]=maxlen;
        }
        int result=0;
        for (int i : dp) {
            result=Math.max(result,i);
        }
        return result;
    }
}
