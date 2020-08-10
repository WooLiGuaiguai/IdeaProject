package 链表;

import Util.ListNode;

public class 两个链表第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
        ListNode node1=pHead1;
        ListNode node2=pHead2;
        while(node1!=node2){
            node1=(node1==null) ? pHead2 :node1.next;
            node2=(node2==null) ? pHead1 :node2.next;
        }
        return node1;
    }
}
//设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
//当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
//同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
//这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。