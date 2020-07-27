package 数组;

/*给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
示例 1:
输入: "aba"
输出: True
示例 2:
输入: "abca"
输出: True
解释: 你可以删除c字符。
注意:
字符串只包含从 Ali.a-z 的小写字母。字符串的最大长度是50000。*/
public class sz5 {
    public static void main(String[] args) {
        System.out.println("abcdfa  "+validPalindrome("abcdfa"));
        System.out.println("deeee  "+validPalindrome("deeee"));
        System.out.println("abca  "+validPalindrome("abca"));
    }
    public static boolean validPalindrome(String s) {
        int i=0,j=s.length()-1 ;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return isPa(s,i+1,j)||isPa(s,i,j-1);
            }
        }
        return true;
    }
    public static boolean isPa(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
