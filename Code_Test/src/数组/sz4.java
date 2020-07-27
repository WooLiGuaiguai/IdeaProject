package 数组;

import java.util.Arrays;
import java.util.HashSet;
/*时间复杂度为 O(N)：只需要遍历所有元素一次
空间复杂度 O(1)：只需要使用两个额外变量*/
public class sz4 {
    /*为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。*/
    private static HashSet<Character> hashSet=new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public static void main(String[] args) {
        String str=reverseVowels("leetcode");
        System.out.println(str);
    }
    public static String reverseVowels(String s){
        if(s==null){
            return null;
        }
        int i=0,j=s.length()-1;
        //用来存放最后的数组
        char []chars=new char[s.length()];
        while (i <= j) {//必须存在相等  如果i j处相邻，且都不为元音，那么存了i就直接退出了
            char ich=s.charAt(i);
            char jch=s.charAt(j);
            if(!hashSet.contains(ich)){
                chars[i++]=ich;
            }else if(!hashSet.contains(jch)){
                chars[j--]=jch;
            }else{
                chars[i++]=jch;
                chars[j--]=ich;
            }
        }
        return new String(chars);
    }
}
