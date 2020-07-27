package 数组;

import java.util.ArrayList;
import java.util.List;

public class sz8 {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(findLongestWord(s,list));
    }
    public static String findLongestWord(String s, List<String> d) {
        String longWord="";//最终返回的就是这个对象
        for (String s1 : d) {//list有几个对象就遍历几次
            int len1=longWord.length();//最长字符串的长度
            int len2=s1.length();//遍历到的target的长度
            //如果target的长度小于最长字符串  就根本不需要遍历这个target了
            //如果目前最长字符串的字典顺序小于target  那么就无需遍历
            if(len1>len2||len1==len2&&longWord.compareTo(s1)<0)
            {
                continue;
            }
            if(isSubstr(s,s1)){
                longWord=s1;
            }
        }
        return longWord;
    }
    private static boolean isSubstr(String s, String target){
        int i=0,j=0;
        while(i<s.length()&&j<target.length()){
            if(s.charAt(i)==target.charAt(j)){
                j++;
            }
            i++;
        }
            return j==target.length();
    }
}
