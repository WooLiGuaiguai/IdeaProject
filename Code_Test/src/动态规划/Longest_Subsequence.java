package 动态规划;

import java.util.Arrays;
import java.util.Comparator;

public class Longest_Subsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{7,2,3,4}));
        System.out.println(findLongestChain(new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(wiggleMaxLength(new int[]{ 1,7,4,9,2,5}));
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
    //最长公共子序列
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int [][]dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
    //最长摆动子序列
    //首先我们考虑使用数组来记录结点i处的最长子序列，如果单纯递增递减只需要一个数组即可，现在需要考虑摆动即两个数组确定当前结点是上升还是下降
    //通过判断状态来确定数组i处的值 是否需要加一
    //设置up 和down等于1是因为默认第一个元素是up或down点  假如它的后一个元素比他大 那么截止到该元素的up必然等于1+1=2 down同理
    public static int wiggleMaxLength(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n=nums.length;
        if(n<=2){
            return n;
        }
        int  up=1,down=1;
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]){
                up=down+1;
            }else{
                down=up+1;
            }
        }
        return Math.max(up,down);
    }
    //一组整数对能够构成的最长链 646
    public static int findLongestChain(int[][] pairs) {
        if(pairs==null||pairs.length==0){
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {//根据二维数组的第一个元素进行排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int []dp=new int[pairs.length];
        //Arrays.fill(dp,1);
        for(int i=0;i<pairs.length;i++){
            int maxLen=1;
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    maxLen=Math.max(maxLen,dp[j]+1);
                }
            }
            dp[i]=maxLen;
        }
        int maxL=0;
        for(int num:dp){
            maxL=Math.max(maxL,num);
        }
        return maxL;
    }
    //最长上升子序列 300
    public static int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n=nums.length;
        int []dp=new int[n];//保存以坐标i上的数结尾的最长递增子序列长度  所以需要跟nums[i]进行比较
        for(int i=0;i<n;i++){
            int maxLen=1;//每次遍历重置最大长度
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    maxLen=Math.max(maxLen,dp[j]+1);//符合要求
                }
            }
            dp[i]=maxLen;
        }
        int maxL=0;
        for(int num:dp){
            maxL=Math.max(maxL,num);
        }
        return maxL;
    }
}
