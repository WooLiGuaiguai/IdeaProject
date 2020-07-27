package 链表;

import Util.ListNode;

public class 链表元素按奇偶聚集 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        ListNode head=oddEvenList(node1);
        while(head.next!=null){
            System.out.print(head+"->");
            head=head.next;
        }
        System.out.println(head);
    }
    //是节点编号的奇偶性  空指针异常有一种是指不能null.next这样
    public static ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode odd=head,even=head.next;//遍历的指针
        ListNode evenHead=even;//head存放奇数链表和evenhead存放偶数链表
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;//没有&& even.next!=null  结果：odd.next=null  odd=null  even.next=null.next 报错
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}
