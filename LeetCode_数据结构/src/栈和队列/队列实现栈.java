package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class 队列实现栈 {
    private Queue<Integer>queue;
    public 队列实现栈(){
        queue=new LinkedList<>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size=queue.size();
        while(size>1){
            size--;
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
