package 字符串;

import java.util.ArrayList;
import java.util.Arrays;

//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
public class 字符串的排列 {
    private ArrayList<String> list=new ArrayList<>();
    public ArrayList<String> Permutation(String str){
        if(str==null||str.length()==0){
            return list;
        }
        char []chars=str.toCharArray();
        Arrays.sort(chars);//用于字典序打印
        boolean []hasUsed=new boolean[chars.length];
        backTracking(chars,hasUsed,new StringBuilder());
        return list;
    }
    public void backTracking(char []chars,boolean[] hasUsed,StringBuilder sb){
        if(sb.length()==chars.length){
            list.add(sb.toString());
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(hasUsed[i]){
                continue;
            }
            if(i!=0 && chars[i]==chars[i-1] && !hasUsed[i-1]){
                continue;
            }
            sb.append(chars[i]);
            hasUsed[i]=true;
            backTracking(chars,hasUsed,sb);
            sb.deleteCharAt(sb.length()-1);
            hasUsed[i]=false;

        }
    }
}
