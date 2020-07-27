package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class divide_num {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
        System.out.println(numSquares(12));
        System.out.println(numDecodings("226"));
    }
    //3.分割整数构成字母字符串
    public static int numDecodings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int n=s.length();
        int []dp=new int[n+1];//整个字符串前i位 可以进行编码的方式数量
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1; //只有一位数字 如果是0 没有编码方式  如果是1-9 只有一种编码方式
        for(int i=2;i<=n;i++){//从个位开始判断  两位两位的取  例如12  23  34
            int gewei=Integer.valueOf(s.substring(i-1,i));
            if(gewei!=0){
                dp[i]=dp[i]+dp[i-1];//dp[i]默认为0  dp[i-1]为前i-1位可编码方式数量
            }
            if (s.charAt(i - 2) == '0') {//判断十位上是不是0  如果是0  那就不用同时判断两位了
                continue;
            }
            int shuangwei=Integer.valueOf(s.substring(i-2,i));
            if(shuangwei<=26) {//小于等于26 意味着可编码
                dp[i]=dp[i]+dp[i-2];//把这两位看成一个字符  然后dp[i]就再加上一个dp[i-2]就行了
            }
        }
        return dp[n];
    }

    //2.给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 279
    public static int numSquares(int n){
        int []dp=new int[n+1];//组成i的完全平方数的个数
        List<Integer>list=list(n);
        //向dp数组填数
        for(int i=1;i<=n;i++){
            //尝试集合中的平方数
            int min_i=Integer.MAX_VALUE;
            for(int l:list){
                if(l>i){
                    break;
                }
                min_i=Math.min(min_i,dp[i-l]+1);//dp[13]=dp[13-4]+1意思是组成9的个数+4（这个平方数）=组成13的个数
            }
            dp[i]=min_i;
        }
        return dp[n];
    }
    //首先要获取完全平方数
    public static List<Integer> list(int n){
        List<Integer>list=new ArrayList<>();
        int input=1;
        int add=3;
        while(input<=n){
            list.add(input);
            input=input+add;
            add+=2;
        }
        return list;
    }
    //1.给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。  343
    //状态数组dp[i]表示：数字 i 拆分为“至少”两个正整数之和的最大乘积。为了方便计算，dp 的长度是 n + 1，值初始化为 1。
    //dp[2]等于 1，外层循环从 3 开始遍历，一直到 n 停止。
    //内层循环 j 从 1 开始遍历，一直到 i 之前停止，它代表着数字 i 可以拆分成 j + (i - j)。
    //j * (i - j)不一定是最大乘积，因为i-j不一定大于dp[i - j]（数字i-j拆分成整数之和的最大乘积）
    public static int integerBreak(int n) {
        int []dp=new int[n+1];
        Arrays.fill(dp,1);
        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }


}
