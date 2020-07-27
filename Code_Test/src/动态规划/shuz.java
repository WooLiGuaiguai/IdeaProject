package 动态规划;

public class shuz {
    public static void main(String[] args) {
        shuz z=new shuz();
        System.out.println(z.numberOfArithmeticSlices(new int[]{0,1,2,3,4}));

    }
    // 数组中等差递增子区间的个数 413
    //分析：1.至少三个数符合要求时才可以称作数列；
    //2.前三个数是等差，后面再加上一个数，如果第234这三个数是等差，那么1234 234都是等差dp[i]=dp[i-1]+1 1表示234这个新的
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int n=A.length;
        int []dp=new int[n];//存放的是以A[i]结尾的等差数列的个数
        for(int i=2;i<n;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i]=dp[i-1]+1;
            }
        }
        int count=0;
        for(int num:dp){
            count=count+num;
        }
        return count;
    }

}
