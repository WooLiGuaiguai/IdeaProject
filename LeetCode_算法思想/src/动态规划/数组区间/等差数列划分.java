package 动态规划.数组区间;
//如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
//
//例如，以下数列为等差数列:
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9

public class 等差数列划分 {
    public static void main(String[] args) {
        int []A={1,2,3,4};
        System.out.println(numberOfArithmeticSlices(A));
    }
    public static int numberOfArithmeticSlices(int[] A){
        //动态规划的思想是  我们要求一共有多少个等差数列，转化为求到每个点的等差数列之和
        int []dp=new int[A.length];//存放的是以A[i]结尾的等差数列的个数
        for (int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i]=dp[i-1]+1;
            }
        }
        int sum=0;
        for (int i : dp) {
            sum+=i;
        }
        return sum;
    }
}
