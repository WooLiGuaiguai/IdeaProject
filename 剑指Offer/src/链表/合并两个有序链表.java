package 链表;

import Util.ListNode;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
public class 合并两个有序链表 {
    public ListNode Merge(ListNode list1, ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode root=null;
        if(list1.val<list2.val){
            root=list1;
            root.next=Merge(list1.next,list2);
        }else{
            root=list2;
            root.next=Merge(list1,list2.next);
        }
        return root;
    }

    public ListNode Merge2(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode list=new ListNode(-1);
        ListNode newHead=list;
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                newHead.next=list2;
                newHead=newHead.next;
                list2=list2.next;
            }else{
                newHead.next=list1;
                newHead=newHead.next;
                list1=list1.next;
            }
        }
        while(list1!=null){
            newHead.next=list1;
            newHead=newHead.next;
            list1=list1.next;
        }
        while(list2!=null){
            newHead.next=list2;
            newHead=newHead.next;
            list2=list2.next;
        }
        return list.next;
    }

}
