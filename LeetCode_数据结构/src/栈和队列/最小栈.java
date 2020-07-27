package 栈和队列;

import java.util.Stack;

public class 最小栈 {
    Stack<Integer> data_stack;
    Stack<Integer> min_stack;
    int min=0;//存储当前最小值
    /** initialize your data structure here. */
    public 最小栈() {
        data_stack=new Stack<>();
        min_stack=new Stack<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int x) {
        data_stack.push(x);
        min=Math.min(min,x);
        min_stack.push(min);
    }

    public void pop() {
        data_stack.pop();
        min_stack.pop();
        min=min_stack.isEmpty()?Integer.MAX_VALUE:min_stack.peek();
    }

    public int top() {
        return data_stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
