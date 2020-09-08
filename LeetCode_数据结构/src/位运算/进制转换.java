package 位运算;

public class 进制转换 {
    public static void main(String[] args) {
        System.out.println(radix(10,2));
    }
    //将任意十进制的数， 转换成任意2到9的进制表示的形式
        private static String radix(long x, long k) {
            StringBuilder sb = new StringBuilder();
            if (x == 0) {
                sb.append(0);
            }
            while (x != 0) {
                sb.append(x % k);
                x /= k;
            }
            return sb.reverse().toString();
        }
}
