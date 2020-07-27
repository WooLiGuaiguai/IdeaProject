package 动态规划.分割整数;
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//返回值是平方数的个数
import java.util.ArrayList;
import java.util.List;

public class 按照平方数来分割整数 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
    public static int numSquares(int n){
        List<Integer> squares=getSquares(n);
        int []dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for (int squ : squares) {
                if(squ>i){
                    break;
                }
                min=Math.min(min,dp[i-squ]+1);
            }
            dp[i]=min;
        }
        return dp[n];
    }
    public static List<Integer> getSquares(int n){
        List<Integer> lisr=new ArrayList<>();
        int input=1;
        int add=3;
        while(input<=n){
            lisr.add(input);
            input=input+add;
            add=add+2;
        }
        return lisr;
    }
}
