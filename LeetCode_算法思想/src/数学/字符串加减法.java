package 数学;

public class 字符串加减法 {
    public static void main(String[] args) {
        System.out.println(addBinary("111","1010"));
        System.out.println(addStrings("920","990"));
    }
    //两个二进制字符串，返回它们的和（用二进制表示）。输入为 非空 字符串且只包含数字 1 和 0。
    public static String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int cur=0;//表示当前的进位
        int i=a.length()-1,j=b.length()-1;
        while(i>=0||j>=0||cur==1){//这个cur==1是因为存在两个字符串当前位置都为0 但可能存在一个进位
            if(i>=0 && a.charAt(i--)=='1'){
                cur++;
            }
            if(j>=0 && b.charAt(j--)=='1'){
                cur++;
            }
            sb.append(cur%2);
            cur=cur/2;
        }
        return sb.reverse().toString();
    }
    //给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
    //你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
    public static String addStrings(String num1, String num2) {
        int cur=0;
        int i=num1.length()-1,j=num2.length()-1;
        StringBuilder sb=new StringBuilder();
        while(i>=0||j>=0||cur>0){
            int x=i<0 ? 0: num1.charAt(i--)-'0';//获取字符串1 i位置上的数字
            int y=j<0 ? 0: num2.charAt(j--)-'0';//获取字符串2 j位置上的数字
            sb.append((x+y+cur)%10);
            cur=(x+y+cur)/10;
        }
        return sb.reverse().toString();
    }
}
