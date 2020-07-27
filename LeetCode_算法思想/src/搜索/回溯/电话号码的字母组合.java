package 搜索.回溯;

import java.util.ArrayList;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    //首先把每个数字所包含的字母组成一个字符串
    private static String []KEYS={"","","abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits){
        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();///用来组成每个字符 再把每个字符添加到集合当中
        if(digits==null||digits.length()==0){
            return list;
        }
        Combination_num(sb,list,digits);
        return list;
    }
    public static void Combination_num(StringBuilder sb,List<String> list,String digits){
        //首先判断返回条件
        if(sb.length()==digits.length()){
            list.add(sb.toString());
            return;
        }
        //然后是具体逻辑分析
        //要组成字符串，也就意味着需要提取每个数字上的字母，所以先获取数字，再获取字母
        int input=digits.charAt(sb.length())-'0';
        String str=KEYS[input];
        //然后是进行遍历，并且回溯
        for (char c : str.toCharArray()) {
            sb.append(c);
            Combination_num(sb,list,digits);
            sb.deleteCharAt(sb.length()-1);//这里替换的是末位的字符
        }
    }
}
