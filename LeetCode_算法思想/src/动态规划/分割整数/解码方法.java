package 动态规划.分割整数;
//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//给定一个只包含数字的非空字符串，请计算解码方法的总数。

//输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

//输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
public class 解码方法 {
    public static void main(String[] args) {
        System.out.println(numDecodings("1123"));
        System.out.println(numDecodings("4123"));
        /*String str="426";
        System.out.println(Integer.valueOf(str.substring(2,3)));*/
    }
    public static int numDecodings(String s){
        if (s==null||s.length()==0){
            return 0;
        }
        int []dp=new int[s.length()+1];//整个字符串前i位 可以进行编码的方式数量
        dp[0]=1;
        dp[1]=s.charAt(0)==0?0:1;//如果只有一位且是0 没有编码方式 否则是1
        for(int i=2;i<=s.length();i++){//当数字是426时，首先i=2 我们取出来的是42，然后i=3，取出来26
            //只有两种 编码的可能 单独一位以及和它前面一位合并起来
            int one=Integer.valueOf(s.substring(i-1,i));//先判断2
            if(one!=0){
                dp[i]=dp[i]+dp[i-1];//个位不是0 那么先把十位看做单独编码  先加上dp[i-1]也就是s="4"的dp值
            }
            if(s.charAt(i-2)=='0'){//然后判断42  首先看十位 如果是0就不用继续了
                continue;
            }
            int two=Integer.valueOf(s.substring(i-2,i));
            if(two<=26){
                dp[i]=dp[i]+dp[i-2];
            }
        }
        return dp[s.length()];
    }

}
