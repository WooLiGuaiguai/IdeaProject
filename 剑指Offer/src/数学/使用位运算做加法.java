package 数学;

public class 使用位运算做加法 {
    public static int Add(int num1,int num2){
        //不考虑进位的话num1^num2,考虑进位的话(num1&num2)<<1
        return (num2==0) ? num1 : Add(num1^num2,(num1&num2)<<1);
    }

    public static void main(String[] args) {
        System.out.println(Add(15,14));
        System.out.println(Add(15,16));
    }
}
