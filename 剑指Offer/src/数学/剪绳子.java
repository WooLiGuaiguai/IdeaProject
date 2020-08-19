package 数学;
//一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n）
//每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
// 例如，当绳子的长度是8时，剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
public class 剪绳子 {
    //尽可能剪长度为3的绳子
    public static int cutRope(int target){
        if(target<2){
            return 0;
        }
        if(target==2||target==3){
            return target;
        }
        //判断有几个3
        int numOf3=target/3;
        //一般有三种情况 7/3--2*2*3 8/3--2*3*3 9/3--3*3*3
        //所以要注意何时将3*1转化成2*2
        if(target%3==1){
            numOf3--;
        }
        int numOf2=(target-3*numOf3)/2;
        return (int)Math.pow(2,numOf2)*(int)Math.pow(3,numOf3);//pow函数计算第一个参数的第二个参数次方
    }

    public static void main(String[] args) {
        System.out.println(cutRope(7));
        System.out.println(cutRope(8));
        System.out.println(cutRope(10));
    }
}
