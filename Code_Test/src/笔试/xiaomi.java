package 笔试;

import java.util.Scanner;

public class xiaomi {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    public static String reverse(String sourceStr, String changeStr) {
        if(changeStr==null||changeStr.length()==0){
            return sourceStr;
        }
        char[]chars=sourceStr.toCharArray();
        int m=sourceStr.length(),n=changeStr.length();
        for(int i=0;i<=m-n;i++){
            for(int j=0;j<n;j++){
                if(sourceStr.charAt(i+j)!=changeStr.charAt(j)) break;
                if(j==n-1){
                    reverse_str(chars,i,i+j);
                }
            }
        }
        return String.valueOf(chars);
    }
    public static void reverse_str(char []chars,int l,int r){
        int n=chars.length;
        if(n<=1){
            return;
        }
        while(l<r){
            char temp=chars[l];
            chars[l]=chars[r];
            chars[r]=temp;
            l++;r--;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
        String _sourceStr;
        try {
            _sourceStr = in.nextLine();
        } catch (Exception e) {
            _sourceStr = null;
        }

        String _changeStr;
        try {
            _changeStr = in.nextLine();
        } catch (Exception e) {
            _changeStr = null;
        }

        res = reverse(_sourceStr, _changeStr);
        System.out.println(res);
    }
}
