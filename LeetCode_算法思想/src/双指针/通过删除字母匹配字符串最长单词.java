package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

输入:
s = "abpcplea", d = ["ale","apple","monkey","plea"]
输出:
"apple"
*/
public class 通过删除字母匹配字符串最长单词 {
    public static void main(String[] args) {
        String s="abpcplea";
        List<String> list= new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        System.out.println(findLongestWord(s,list));
    }
    public static String findLongestWord(String s, List<String> d){
        String longword="";
        for (String s1 : d) {
            int len=longword.length();
            int len1=s1.length();
            if(len1<len||(len1==len&&longword.compareTo(s1)<0)){//后面这项是用来判断字典顺序是否大于前面的longword，要是大于不用后续的考虑
                continue;
            }
            if(issbuTree(s,s1)){
                longword=s1;
            }
        }
        return longword;
    }
    public static  boolean issbuTree(String s,String s1){
        int i=0,j=0;
        while(i<s.length()&&j<s1.length()){
            if(s.charAt(i)==s1.charAt(j)){
                j++;
            }
            i++ ;
        }
        if(j==s1.length()){
            return true;
        }
        return false;
    }
}
