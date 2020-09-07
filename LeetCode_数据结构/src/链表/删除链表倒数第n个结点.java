package 链表;

import Util.ListNode;

public class 删除链表倒数第n个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right=head;
        while(n>0){
            if(right!=null){
                right=right.next;
                n--;
            }else{
                return null;
            }
        }
        if(right==null){
            return null;
        }
        ListNode left=head;
        while(right.next!=null){
            left=left.next;
            right=right.next;
        }
        left.next=left.next.next;
        return head;
    }
}
