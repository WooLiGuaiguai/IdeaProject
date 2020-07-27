package 双指针;

import java.util.Arrays;
import java.util.HashSet;

/*编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
示例 1:
输入: "hello"
输出: "holle"
示例 2:
输入: "leetcode"
输出: "leotcede"
*/
public class 翻转字符串中的元音字母 {
    public static void main(String[] args) {
        System.out.println(reverseVowels(" "));
    }
    private static HashSet<Character> set=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public static String reverseVowels(String s){
        if(s==null){
            return null;
        }
        char[] chars=new char[s.length()];
        int left=0,right=s.length()-1;
        while(left<=right){
            char cleft=s.charAt(left);
            char cright=s.charAt(right);
            if(set.contains(cleft) &&set.contains(cright)){
                chars[left]=cright;
                chars[right]=cleft;
                left++;
                right--;
            }else if(set.contains(cleft)){
                chars[right]=cright;
                right--;
            }else if(set.contains(cright)){
                chars[left]=cleft;
                left++;
            }else{
                chars[right]=cright;
                chars[left]=cleft;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
