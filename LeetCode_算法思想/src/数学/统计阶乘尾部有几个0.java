package 数学;

public class 统计阶乘尾部有几个0 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
        System.out.println(trailingLastOne(5));
    }
    //1.给定一个整数 n，返回 n! 结果尾数中零的数量。
    //尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可。
    //对于一个数 N，它所包含 5 的个数为：N/5 + N/5^2 + N/5^3 + ...
    //N/5表示不大于N的数字中每个5的倍数出一个5  N/5^2表示不大于N的数字中，每个25的倍数出一个5
    //例如25的阶乘包含5的数字 5 10 15 20 25，而25=5*5 第一个5是N/5贡献的  第二个5是N/25贡献的
    public static int trailingZeroes(int n) {
        return n==0 ? 0 : trailingZeroes(n/5)+n/5;
    }

    //2.如果统计的是 N! 的二进制表示中最低位 1 的位置，只要统计有多少个 2 即可
    public static int trailingLastOne(int n){//1*2*3*4*5    0111 1000
        return n==0? 0:trailingLastOne(n/2)+n/2;
    }
}
