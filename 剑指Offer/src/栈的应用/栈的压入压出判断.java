package 栈的应用;

import java.util.Stack;

public class 栈的压入压出判断 {
    public static void main(String[] args) {
        int []a={1,2,3,4,5};
        int []b={4,3,5,1,2};
        int []c={4,5,3,2,1};
        System.out.println(IsPopOrder(a,b));//False
        System.out.println(IsPopOrder(a,c));//True
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer>stack=new Stack<>();//辅助栈
        if(pushA==null||popA==null||pushA.length!=popA.length){
            return false;
        }
        int index=0;//用来标记辅助栈的位置
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
