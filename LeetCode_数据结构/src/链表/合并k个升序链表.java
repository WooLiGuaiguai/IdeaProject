package 链表;

import Util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并k个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val<o2.val){
                    return -1;
                }else if(o1.val==o2.val){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        ListNode head=new ListNode(0);
        ListNode pnext=head;
        for(int i=0;i<lists.length;i++){//先把每个链表第一个结点添加进来
            if(lists[i]!=null){
                queue.add(lists[i]);
            }
        }
        while(!queue.isEmpty()){
            //输出队列第一个元素  判断他所在链表是否为空  不为空添加进来
            pnext.next=queue.poll();
            pnext= pnext.next;
            if(pnext.next!=null){
                queue.add(pnext.next);
            }
        }
        return head.next;
    }
}
