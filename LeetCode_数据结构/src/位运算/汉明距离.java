package 位运算;

public class 汉明距离 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
    public static int hammingDistance(int x, int y) {
        int z=x^y;
        return Integer.bitCount(z);
    }
}
