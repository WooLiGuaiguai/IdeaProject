package 链表;
import Util.ListNode;
import java.util.Stack;

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
}
