package 链表;

import java.util.ArrayList;
import java.util.Stack;

public class ListNode {
    public int val;
    ListNode next=null;
    public ListNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(5);
        ListNode node4=new ListNode(7);
        Lists list=new Lists();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        ListNode node5=new ListNode(2);
        ListNode node6=new ListNode(4);
        ListNode node7=new ListNode(6);
        ListNode node8=new ListNode(8);
        Lists list1=new Lists();
        list1.add(node5);
        list1.add(node6);
        list1.add(node7);
        list1.add(node8);
        list.list();
        list1.list();
        //System.out.println(ReverseList(node1).val);
        //System.out.println(Merge(list,list1));
    }
    //输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    public static ListNode Merge(ListNode list1,ListNode list2){
        if(list1==null&&list2==null){
            return null;
        }
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        //创建一个头结点
        ListNode list3=new ListNode(-1);
        list3.next=null;
        //建一个新链表的头结点指向listNode
        ListNode listNode=list3;
        while(list1!=null&&list2!=null){
            if(list1.val > list2.val) {
                list3.next=list2;
                list3=list3.next;
                list2=list2.next;
            } else {
                list3.next=list1;
                list3=list3.next;
                list1=list1.next;
            }
        }
        while(list1!=null){
            list3.next=list1;
            list1=list1.next;
            list3=list3.next;
        }
        while(list2!=null){
            list3.next=list2;
            list2=list2.next;
            list3=list3.next;
        }
        return listNode.next;
    }
    //输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<Integer> stack=new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode bef=head;
        ListNode aft=head;
        if(head==null){
            return head;
        }
        if(k==0||k<0){
            System.out.println("输入错误");
            return null;
        }
        for(int i=0;i<k-1;i++){
            aft=aft.next;
        }
        if(aft==null){
            System.out.println("链表不够k");
            return null;
        }
        while(aft.next!=null){
            bef=bef.next;
            aft=aft.next;
        }
        return bef;
    }
    //输入一个链表，反转链表后，输出新链表的表头。
    public static ListNode ReverseList(ListNode head) {
        if(head==null){
            return head;
        }
        //nextNode用来保存翻转前的下一个节点  pre是反转后下一个节点  head是当前结点指针
        ListNode nextNode=null;
        ListNode pre=null;
        while(head!=null){
            //先保存nextNode
            nextNode=head.next;
            //然后断开后面连接  并连上后面
            head.next=pre;
            //继续移动连接下面
            pre=head;
            head=nextNode;
        }
        return pre;
    }

}
