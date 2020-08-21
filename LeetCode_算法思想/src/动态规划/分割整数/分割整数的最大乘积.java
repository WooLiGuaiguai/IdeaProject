package 动态规划.分割整数;
//对于给定的数 n，F(n)F(n) 表示将 n 分解成多个(≥2)整数的最大乘积，那么有以下几种情况：
//1.将n分解成两个数:
//F(n)=i∗(n−i), (i=1,2,...,n−1)
//
//2.将n分解成两个以上的数:
//也就是要对 i 和 n - i 进一步分解，那么就有三种情况（继续分解其中一个或两个都继续分解）
//将i和n - i进一步分解的最大乘积分别记为 F(i)和F(n - i)，那么有：
//
//F(n)=max{  i * F(n - i)， 对 n−i 继续分解
//           F(i) * (n - i) ，对 i 继续分解
//           F(i) * F(n- i)} ，对 i和 n−i 都继续分解
//观察上面的表达式，不难发现，当i取遍[1,n-1]时，由于i和n - i的取值对称
// i∗F(n−i) 和 F(i)∗(n−i)的取值集合是一样的，所以只取其中一种就可以了
// 对于F(i)*F(n-i)，其实这种情况也是不用考虑的，因为 i*(n - i)和i * F(n - i)已经包含了所有的分解情况了。那么整个表达式就为：
//F(n)=max{i∗(n−i),i∗F(n−i)}, (i=1,2,...,n−1)

import java.util.Arrays;

public class 分割整数的最大乘积 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    //给定一个整数  求分割之后可以得到的最大乘积
    public static int integerBreak(int n){
        int []dp=new int[n+1];
        Arrays.fill(dp,1);
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        for (int i=3;i<=n;i++){//把每个i当做是一个n ：动态规划的思想求出前面一个的dp值 方便求后面的dp值
            for (int j=1;j<i;j++){//分解成j和i-j
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
