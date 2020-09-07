package 链表;
import Util.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*给出两个非空的链表用来表示两个非负的整数。
其中，它们各自的位数是按照 顺序/逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
逆序实例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/
public class 两数相加 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(9);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(3);

        ListNode node5=new ListNode(7);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(2);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        node5.next=node6;
        node6.next=node7;
        ListNode head=addTwoNumbers(node1,node5);

        while(head.next!=null){
            System.out.print(head+"->");
            head=head.next;
        }
        System.out.print(head);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        ListNode head=new ListNode(-1);
        int carry=0;//进位
        while(!stack1.isEmpty()||!stack2.isEmpty()||carry!=0){//carry不等于0 是防止两者都为空，但后一位有进上来的carry
            int x=(stack1.isEmpty())?0:stack1.pop();
            int y=(stack2.isEmpty())?0:stack2.pop();
            int sum=x+y+carry;//出栈的两位加上前一位的进位数
            ListNode node=new ListNode(sum%10);
            node.next=head.next;
            head.next=node;
            carry=sum/10;//进位数
        }
        return head.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Queue<Integer> queue1=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();
        while(l1!=null){
            queue1.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            queue2.add(l2.val);
            l2=l2.next;
        }
        ListNode head=new ListNode(-1);
        int carry=0;//进位
        while(!queue1.isEmpty()||!queue2.isEmpty()||carry!=0){//carry不等于0 是防止两者都为空，但后一位有进上来的carry
            int x=(queue1.isEmpty())?0:queue1.poll();
            int y=(queue2.isEmpty())?0:queue2.poll();
            int sum=x+y+carry;//出栈的两位加上前一位的进位数
            ListNode node=new ListNode(sum%10);
            node.next=head.next;
            head.next=node;
            carry=sum/10;//进位数
        }
        return head.next;
    }
}
