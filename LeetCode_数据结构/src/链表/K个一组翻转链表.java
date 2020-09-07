package 链表;

import Util.ListNode;

/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

给你这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5*/
public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //首先为便于操作，设置头结点
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        //为了后续的连接，保存被翻转部分的前驱和后继
        ListNode pre=newHead,pnext=newHead;
        ListNode end=newHead;//一个指针用于移动 确认具体位置
        while(end!=null){
            for(int i=0;i<k && end!=null;i++){//找到翻转的末位结点
                end=end.next;
            }
            if(end==null){//末尾的长度 不够
                break;
            }
            ListNode start=pre.next;//翻转的初始结点
            pnext=end.next;//保存翻转部分的后继节点
            end.next=null;//断开这部分链表
            pre.next=reverse(start);//完成前驱后继连接
            start.next=pnext;
            pre=start;
            end=start;
        }
        return newHead.next;
    }
    public ListNode reverse(ListNode head){
        ListNode newHead=null;
        ListNode p=head;
        while(p!=null){
            ListNode pnext=p.next;
            p.next=newHead;
            newHead=p;
            p=pnext;
        }
        return newHead;
    }
}
