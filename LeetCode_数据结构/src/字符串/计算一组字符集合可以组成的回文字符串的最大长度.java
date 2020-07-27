package 字符串;
/*使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。
因为回文字符串最中间的那个字符可以单独出现，所以如果有单独的字符就把它放到最中间。*/
public class 计算一组字符集合可以组成的回文字符串的最大长度 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccbddd"));
    }
    public static int longestPalindrome(String s) {
        int []arr=new int[256];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int Length=0;//存储最大长度
        for (int i : arr) {
            //不用i%2==0进行判断  因为一个字符如果出现了三次 应该取出来两次加上
            Length=Length+(i/2)*2;
        }
        if(Length<s.length()){//如果长度不等于初始字符串 肯定有计数为奇数的
            Length=Length+1;
        }
        return Length;
    }
}
