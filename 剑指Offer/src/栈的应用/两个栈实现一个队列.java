package 栈的应用;

import java.util.Stack;

public class 两个栈实现一个队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    //假设队列（队头）stack1的栈底--->stack2的栈底（队尾）
//添加新的结点
    public void push(int node) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }
//现在要将队头弹出
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
