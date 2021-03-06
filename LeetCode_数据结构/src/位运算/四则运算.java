package 位运算;
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//返回被除数 dividend 除以除数 divisor 得到的商。
//整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//示例 1:
//输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

import static java.lang.Math.abs;

public class 四则运算 {
    public static void main(String[] args) {
        System.out.println((10>0)^(20>0));
        System.out.println(divide(19,3));
        System.out.println(add(3,1));
    }
    public static int add(int a,int b){
        if(b==0){
            return a;
        }
        int sum=a^b;
        int carry=(a&b)<<1;
        return add(sum,carry);
    }
    public static int divide(int dividend, int divisor) {
        // ^ 是异或运算符，相同为0 不同为1
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        // 将整数全部转化为负数再进行运算
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) {
            divisor = -divisor;
        }
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            // // 左移一位相当于乘以二，右移一位相当于除以二
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }

}
