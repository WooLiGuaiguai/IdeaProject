package 链表;
import Util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ListNode newNode=listNode;
        Stack<ListNode> stack=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        while (newNode!=null){
            stack.push(newNode);
            newNode=newNode.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop().val);
        }
        return list;
    }
}
