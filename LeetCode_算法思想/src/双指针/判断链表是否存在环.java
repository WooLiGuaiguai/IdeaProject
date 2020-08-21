package 双指针;

import Util.ListNode;

public class 判断链表是否存在环 {
    public boolean hasCycle(ListNode head){
        if (head==null){
            return false;
        }
        //现在至少一个节点
        ListNode left=head;
        ListNode right=head.next;
        while(left!=null&&right!=null&&right.next!=null){
            if(left==right){
                return true;
                //输出该入口结点
                /*
                * left=head;
                * while(left!=right){
                *   left=left.next;
                *   right=right.next;
                * }
                * return left;*/
            }
            left=left.next;
            right=right.next.next;
        }
        return false;
    }
}
