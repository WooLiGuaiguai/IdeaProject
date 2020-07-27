package 搜索.回溯;
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
//示例:
//输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"]

import java.util.ArrayList;
import java.util.List;

public class IP地址划分 {
    public static void main(String[] args) {
        String str="25525511135";
        System.out.println(restoreIpAddresses(str));
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String>list=new ArrayList<>();//存储最后的结果
        StringBuilder sb=new StringBuilder();//存储每次的字符串
        doSomething(list,sb,s,0);//k表示的是划分的个数
        return list;
    }
    public static void doSomething(List<String>list,StringBuilder sb,String s,int k){
        if(k==4||s.length()==0){
            if (k==4&&s.length()==0){
                list.add(sb.toString());
            }
            return;
        }
        //这里选取的是局部来看 因为每个分隔符之前最多有三个字符,并且需要考虑如果最后剩2个字符，i的选取要小于s.length()
        for(int i=0;i<=2&&i<s.length();i++){
            if(i!=0&&s.charAt(0)=='0'){
                break;
            }
            String part=s.substring(0,i+1);
            if(Integer.valueOf(part)<=255){//表示可以添加
                if(sb.length()!=0){
                    part="."+part;//表示前面已经有字符了 现在需要按照 .xxx 的形式添加
                }
                //否则老实添加
                sb.append(part);
                doSomething(list,sb,s.substring(i+1),k+1);
                sb.delete(sb.length()-part.length(),sb.length());
            }
        }
    }
}
