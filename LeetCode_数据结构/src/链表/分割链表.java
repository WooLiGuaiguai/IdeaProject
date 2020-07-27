package 链表;

import Util.ListNode;

public class 分割链表 {
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

        ListNode[]  lists=splitListToParts(node1,4);
        for (ListNode head : lists) {
            while(head.next!=null){
                System.out.print(head+"->");
                head=head.next;
            }
            System.out.println(head);
        }

    }
    public static ListNode[] splitListToParts(ListNode root, int k) {
        int N=0;
        ListNode node=root;
        while(node!=null){
            N++;
            node=node.next;
        }
        int size=N/k;
        int yushu=N%k;
        ListNode[] arrays=new ListNode[k];
        ListNode pnext=root;//用来遍历
        for(int i=0;i<k&&pnext!=null;i++){//因为不知道root的长度是不是 大于k的 停止条件不确定
            arrays[i]=pnext;
            int cursize=size+((yushu>0)?1:0);
            yushu--;//这里是由于假设6分成4份  应该是 2 2 1 1 余数是2 size=1，应该循环的时候给前面的数组每个加一 直到余数小于等于0
            for(int j=0;j<cursize-1;j++){//上来头结点已经指向第一个了
                pnext=pnext.next;
            }
            ListNode next=pnext.next;//保存下一个结点
            pnext.next=null;//断开
            pnext=next;
        }
        return arrays;
    }
}
