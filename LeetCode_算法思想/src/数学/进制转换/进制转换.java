package 数学.进制转换;
//16进制和26进制没有掌握
public class 进制转换 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(-8));
        System.out.println(toHex(19));
    }
    //7进制 给定一个整数，将其转化为7进制，并以字符串形式输出
    public static String convertToBase7(int num) {
        //return Integer.toString(num,7);
        if (num==0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        boolean isNegative=num<0;//判断是否是负数
        if(isNegative){//转化成正数
            num=-num;
        }
        while (num>0){
            sb.append(num%7);
            num=num/7;
        }
        String string=sb.reverse().toString();
        return isNegative?"-"+string:string;
    }
    //16进制 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
    //补码即原码除符号位外，全部取反,再+1  1000000000000001取反后是1111111111111110，再+1即1111111111111111
    public static String toHex(int num) {
        char []chars="0123456789abcdef".toCharArray();
        if(num==0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        while(num>0){
            int end=(num&15);//比较二进制的差异
            sb.append(chars[end]);
            num>>>=4;//每次的操作是4个bit位 所以无符号右移4位
            //因为考虑的是补码形式，因此符号位就不能有特殊的意义，需要使用无符号右移，左边填 0
        }
        return sb.reverse().toString();
    }
    //26进制
    public static String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        n--;
        return convertToTitle(n / 26) + (char) (n % 26 + 'A');
    }

}
