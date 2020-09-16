package 字符串;

import java.util.Stack;

public class 字符串匹配 {
    public static void main(String[] args) {
        System.out.println(isValid("(([{}]))"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(])"));

    }
    //1.括号匹配
    public static boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        char []chars=s.toCharArray();
        for(char ch:chars){
            if(ch=='('||ch=='['||ch=='{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    if(ch==')'&&stack.peek()=='('){
                        stack.pop();
                    }else if(ch==']'&&stack.peek()=='['){
                        stack.pop();
                    }else if(ch=='}'&&stack.peek()=='{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
