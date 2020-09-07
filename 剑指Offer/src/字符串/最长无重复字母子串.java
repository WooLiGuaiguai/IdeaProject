package 字符串;

import java.util.HashSet;
import java.util.Set;

//从字符串中找出一个最长的不包含重复数字的子字符串的长度。例如在字符串中arabcacfr",最长非重复子字符串为“rabc”或”acfr”，长度为4.
//第一个方法返回字符串  第二个方法返回字符串长度
public class 最长无重复字母子串 {
    public static String FindStuStr(String str){
        int []positions=new int[26];//标记每个字母上次出现的位置
        int maxLen=1;//标记字符串最大长度
        int maxIndex=0;//标记最大字符串最后一位下标
        int []lines=new int[str.length()];//标记以当前字母结尾的非重复子串的最大长度
        //首先处理第一个字母
        positions[str.charAt(0)-'a']=0;
        lines[0]=1;
        for(int i=1;i<str.length();i++){
            int preposition=positions[str.charAt(i)-'a'];
            //判断是不是第一次出现
            if (preposition>=0){//出现过
                //判断当前字母的前一次出现位置是否在前一个字母的最短子串区间
                if(i-preposition>lines[i-1]){//不在---a....b....b a
                    lines[i]=lines[i-1]+1;
                }else{                       //b...a...b a
                    lines[i]=i-preposition;
                }
            }else{//没有出现过
                lines[i]=lines[i-1]+1;
            }
            positions[str.charAt(i)-'a']=i;
            if(maxLen<lines[i]){
                maxLen=lines[i];
                maxIndex=i;
            }
        }
       return str.substring(maxIndex-lines[maxIndex+1],maxIndex+1);
    }
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        String str="arabcacfrrrr";
        System.out.println(FindStuStr(str));
        String str1= " ";
        System.out.println(lengthOfLongestSubstring(str1));
    }
}
