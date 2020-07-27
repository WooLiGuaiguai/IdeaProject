package 分治;

import java.util.ArrayList;
import java.util.List;

//给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
// 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
//输入: "2-1-1"
//输出: [0, 2]
//解释:
//((2-1)-1) = 0
//(2-(1-1)) = 2
public class 为运算表达式设置优先级 {
    public static void main(String[] args) {
        String str="2*3-4*5";
        System.out.println(diffWaysToCompute(str));
    }
    //首先考虑的是以每个运算符作为操作的分界点
    public static List<Integer> diffWaysToCompute(String input){
        List<Integer> list=new ArrayList<>();
        //遍历这个字符串
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'){
                List<Integer> left=diffWaysToCompute(input.substring(0,i));
                List<Integer> right=diffWaysToCompute(input.substring(i+1));
                //开始对这两个集合所有可能进行组合
                for(int l:left){
                    for(int r:right){
                        switch(ch){
                            case '+':
                                list.add(l+r);
                                break;
                            case '-':
                                list.add(l-r);
                                break;
                            case '*':
                                list.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if(list.size()==0){//如果集合的大小为0 意味着没有找到运算符
            list.add(Integer.valueOf(input));
        }
        return list;
    }
}
