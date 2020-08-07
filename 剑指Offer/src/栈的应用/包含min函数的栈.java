package 栈的应用;

import java.util.Iterator;
import java.util.Stack;

public class 包含min函数的栈 {
    Stack<Integer> stack=new Stack<>();
    public int min(){
        int min=stack.peek();
        Iterator<Integer> iterator=stack.iterator();
        int tmp=0;
        while(iterator.hasNext()){
            tmp=iterator.next();
            if(min>tmp){
                min=tmp;
            }
        }
        return min;
    }
}
