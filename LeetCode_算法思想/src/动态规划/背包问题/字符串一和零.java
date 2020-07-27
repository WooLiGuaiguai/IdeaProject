package 动态规划.背包问题;
//01 字符构成最多的字符串
///现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
//
//你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
public class 字符串一和零 {
    public static int findMaxForm(String[] strs, int m, int n){//这是背包二元约束问题
        if(strs==null||strs.length==0){
            return 0;
        }
        int [][]dp=new int[m+1][n+1];//空间优化之后的数组本来是一维的，现在双重约束
        for(String str:strs){//逐步遍历字符串数组  对于每个字符串进行判断
            int ones=0,zeros=0;
            char []chars=str.toCharArray();
            //先获取资源数 也就是0和1的个数
            for (char aChar : chars) {
                if(aChar=='0'){
                    zeros++;
                }else{
                    ones++;
                }
            }
            for(int i=m;i>=zeros;i--){//获取到的0和1的个数相当于是背包问题每个物体的体积j
                for(int j=n;j>=ones;j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[]Array = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(Array,m,n));
    }
}
