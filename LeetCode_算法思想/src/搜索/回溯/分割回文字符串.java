package 搜索.回溯;
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//返回 s 所有可能的分割方案。
//输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//]

import java.util.ArrayList;
import java.util.List;

public class 分割回文字符串 {
    public static void main(String[] args) {
        String str="isPalindrome";
        String str2="aab";
        System.out.println(partition(str));
        System.out.println(partition(str2));
    }
    public static List<List<String>> partition(String s){
        List<List<String>> lists=new ArrayList<>();
        List<String> list=new ArrayList<>();
        doCut(lists,list,s);
        return lists;
    }
    public static void doCut(List<List<String>> lists,List<String> list,String s){
        if(s.length()==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        char []chars=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(isPalindrome(chars,0,i)){
                list.add(s.substring(0,i+1));
                doCut(lists,list,s.substring(i+1));
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isPalindrome(char []chars,int start,int end){
        while(start<end){
            if(chars[start]!=chars[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;//如果start==end 表示同一个字母 直接返回true
    }
}
