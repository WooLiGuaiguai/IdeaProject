package 数学;

public class 判断是3的n次方 {
    public static boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(81));
    }
}
