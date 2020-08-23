package 排序;
//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
//输入:"tree"
//输出:"eert"
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 根据字符出现频率排序 {
    public static void main(String[] args) {
        System.out.println(frequencySort("treeggttrrffjkloiu"));
    }
    public static String frequencySort(String s){
        char []chars=s.toCharArray();
        Map<Character,Integer>map=new HashMap<>();
        for(char c:chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //需要按照出现的频率排序 所以来一个集合类型的数组存放出现频率为i的字符
        List<Character>[] frequent=new ArrayList[s.length()+1];
        for(char ch:map.keySet()){
            int fre=map.get(ch);
            if(frequent[fre]==null){
                frequent[fre]=new ArrayList<>();
            }
            frequent[fre].add(ch);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=frequent.length-1;i>=0;i--){//i表示当前表示的频数
            if(frequent[i]==null){
                continue;
            }
            for(int j=0;j<frequent[i].size();j++){//开始对集合数组中的每个集合遍历
                int count=i;//计算器
                while(count>0){
                    sb.append(frequent[i].get(j));
                    count--;
                }
            }
        }
        return sb.toString();
    }
}
