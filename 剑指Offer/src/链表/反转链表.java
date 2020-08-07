package 链表;

import Util.ListNode;

public class 反转链表 {
    public static ListNode ReverseList(ListNode head){
        if(head==null){
            return null;
        }
        ////nextNode用来保存翻转前的下一个节点  root是反转后下一个节点  head是当前结点指针
        ListNode root=null;//新头结点
        ListNode nextNode=null;//保存拆下来结点的下一个结点
        while (head!=null){
            nextNode=head.next;//保存下一个结点
            head.next=root;//连接到新的链表
            root=head;//头插法移动root结点
            head=nextNode;//head回到之前保存结点
        }
        return root;
    }

}
