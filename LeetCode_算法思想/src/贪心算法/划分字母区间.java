package 贪心算法;

import java.util.ArrayList;
import java.util.List;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。

//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。

public class 划分字母区间 {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
    }
    public static List<Integer> partitionLabels(String S){
        int[] indexs=new int[26];//为每个字母最后出现位置进行存储
        for (int i=0;i<S.length();i++){
            indexs[S.charAt(i)-'a']=i;//不断更新最后的位置
        }
        List<Integer> list=new ArrayList<>();//存储每个区间的长度
        int firstindex=0;//区间的起始位置
        while (firstindex<S.length()){
            int lastindex=firstindex;//初始化区间的终止位置
            for (int i=firstindex;i<S.length() && i<=lastindex;i++){
                int index=indexs[S.charAt(i)-'a'];//获取当前字母的最后位置
                if(index>lastindex){//更新该区间最后坐标
                    lastindex=index;
                }
            }
            list.add(lastindex-firstindex+1);
            firstindex=lastindex+1;
        }
        return list;
    }
}
