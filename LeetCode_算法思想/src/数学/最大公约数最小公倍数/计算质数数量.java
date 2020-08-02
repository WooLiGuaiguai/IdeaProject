package 数学.最大公约数最小公倍数;
//统计所有小于非负整数 n 的质数的数量。
//输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
public class 计算质数数量 {
    public static int countPrimes(int n) {
        int count=0;
        boolean []isBeishu=new boolean[n+1];
        for (int i = 2; i < n; i++) {
            if(isBeishu[i]){
                continue;//如果是已经访问过的质数的倍数 那么跳过
            }
            count++;
            //将当前访问到的质点的倍数都标记上
            for (long j=(long) i*i;j<n;j+=i){
                isBeishu[(int)j]=true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(499979));
    }
}
