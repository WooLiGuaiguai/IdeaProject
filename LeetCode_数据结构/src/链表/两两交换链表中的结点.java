package 链表;

import Util.ListNode;

/*给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
示例:
给定 1->2->3->4, 你应该返回 2->1->4->3.
*/
public class 两两交换链表中的结点 {
    public ListNode swapPairs(ListNode head) {
        //头结点存储的一般是第一个结点的值  所以也要保持头结点不发生变化
        ListNode newHead=new ListNode(-1);
        ListNode pnext=newHead;//设置一个移动的指针结点
        while(pnext.next!=null && pnext.next.next!=null){
            //当需要交换的两个结点不为空 将他们进行保存
            ListNode l1=pnext.next;
            ListNode l2=pnext.next.next;
            //保存后面尚未交换的结点
            ListNode tmp=l2.next;
            //交换
            l1.next=tmp;
            l2.next=l1;
            pnext.next=l2;
            pnext=l1;
        }
        return newHead.next;
    }
}
