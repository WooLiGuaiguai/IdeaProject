package 贪心算法;

import java.util.ArrayList;
import java.util.List;

public class GA9 {
    public static void main(String[] args) {
        String s="ababcbacadefegdehijhklij";
        List<Integer> list=partitionLabels(s);
        for (Integer integer : list) {
            System.out.print(integer+"  ");
        }
    }
    public static List<Integer> partitionLabels(String S){
        int [] LastIndexOfchar=new int[26];//存储每个字母出现的最后位置
        //将每个字母的最后出现位置放到数组中
        for(int i=0;i<S.length();i++){
            LastIndexOfchar[charToint(S.charAt(i))]=i;//i位置上的字母出现的最后位置设为i 不断更新
        }
        List<Integer> list=new ArrayList<>();
        int firstIndex=0;
        while(firstIndex<S.length()){
            int lastIndex=firstIndex;
            for(int i=firstIndex;i<S.length()&&i<=lastIndex;i++){//可以理解为两个a之间有没有一个字母的位置大于最后一个a 有就更新
                int index=LastIndexOfchar[charToint(S.charAt(i))];//先将i位置上字母的最大位置表示出来
                if(index>lastIndex){
                    lastIndex=index;//如果当前位置上字母的最大位置大于之前的 那么更新
                }
            }
            list.add(lastIndex-firstIndex+1);
            firstIndex=lastIndex+1;
        }
        return list;
    }
    private static int charToint(char c){//这个字母应该位于数组的哪个位置
        return c-'a';
    }
}
