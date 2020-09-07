package 数字;
//要注意的是反转之后是否超出界限
public class 整数反转 {
    public int reverse(int x) {
        int result=0;
        while(x!=0){
            int num=x%10; //84
            x=x/10;
            //7或8是因为最大值2的31次方是2147483648，最小值负2的31次方减一是-2147483647，这两个数值的个位数是7和8.
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && num > 7))
                return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && num < -8))
                return 0;
            result=result*10+num;
        }
        return result;
    }


    public static void main(String[] args) {
        整数反转 a=new 整数反转();
        System.out.println(a.reverse(-123));
        System.out.println(a.reverse(123));
    }
}
