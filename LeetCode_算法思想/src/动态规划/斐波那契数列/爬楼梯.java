package 动态规划.斐波那契数列;

public class 爬楼梯 {
    //有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法。
    public int climbStairs(int n){
        if(n<=2){
            return n;
        }
        int []dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //有 N 阶楼梯，每次可以上一阶或者2 3 4...n阶，求有多少种上楼梯的方法。
    public int climbStairs2(int n){
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        if(n==1||n==2){
            return n;
        }else{
            for(int i=3;i<=n;i++){
                dp[i]=0;//初始化
                for(int j=0;j<i;j++){//对他前面的数相加求和
                    dp[i]+=dp[j];
                }
            }
        }
        return dp[n];
    }
    //斐波那契数列前n项求和
    public int climbStairs3(int n){
        int a=1,b=1,c=0;
        if(n==1||n==2){
            return n;
        }else {
            int sum = 2;
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
                sum = sum + c;
            }
            return sum;
        }
    }
    public static void main(String[] args) {
        爬楼梯 p1=new 爬楼梯();
        System.out.println(p1.climbStairs(5));
        System.out.println(p1.climbStairs2(10));
        System.out.println(p1.climbStairs3(5));
    }
}
