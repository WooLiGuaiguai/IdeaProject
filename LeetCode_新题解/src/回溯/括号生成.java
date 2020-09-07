package 回溯;
/*数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

输入：n = 3
输出：[ "((()))", "(()())", "(())()", "()(())", "()()()"]  */
import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        generate(list,sb,0,0,n);
        return list;
    }
    //left和right分别代表左括号和右括号的个数
    public void generate(List<String> list,StringBuilder sb,int left,int right,int maxnum){
        if(sb.length()==maxnum*2){
            list.add(sb.toString());
            return;
        }
        if(left<maxnum){
            sb.append("(");
            generate(list,sb,left+1,right,maxnum);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(")");
            generate(list,sb,left,right+1,maxnum);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        括号生成 a=new 括号生成();
        System.out.println(a.generateParenthesis(3));
    }
}
