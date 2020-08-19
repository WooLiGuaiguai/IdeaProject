package 链表;

import Util.ListNode;

//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class 删除链表重复结点 {
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode next=pHead.next;
        if(pHead.val!=next.val){
            pHead.next=deleteDuplication(pHead.next);
            return pHead;
        }else{
            //如果相等，看看后面是否还有仍旧重复的，后面这个指针向后移动，当不相同时跳出循环
            while(next!=null && pHead.val==next.val){
                next=next.next;
            }
            return deleteDuplication(next);//传参 参数为相同之后第一个不同
        }
    }
}
