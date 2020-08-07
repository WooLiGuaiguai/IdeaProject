package 链表;

import Util.ListNode;

public class 链表中倒数第k个结点 {
    public static ListNode FindKthToTail(ListNode head, int k){
        ListNode right=head;
        ListNode left=head;
        if(head==null){
            return head;
        }
        if(k<=0){
            return null;
        }
        for(int i=0;i<k-1;i++){
            right=right.next;
        }
        if(right==null){
            return null;
        }
        while(right.next!=null){
            left=left.next;
            right=right.next;
        }
        return left;
    }
    public ListNode FindKthToTail2(ListNode head,int k){
        if(head==null){
            return null;
        }
        ListNode root=head;
        int count=0;
        while(root!=null){
            root=root.next;
            count++;
        }
        if(count<k){
            return null;
        }
        for(int i=0;i<count-k;i++){
            head=head.next;
        }
        return head;
    }
    public static void main(String[] args) {

    }
}
