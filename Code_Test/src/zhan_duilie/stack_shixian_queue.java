package zhan_duilie;

import java.util.Stack;

public class stack_shixian_queue {
    Stack<Integer>stack1=new Stack<>();
    Stack<Integer>stack2=new Stack<>();
    public  void push(int node){
        //stack1实现入队列
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }
    public int pop(){
        //队列先进先出 现在先进去的在栈底 取出来  stack2负责出队列
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
