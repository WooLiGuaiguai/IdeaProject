package 链表;

import Util.ListNode;

import java.util.Stack;

public class 回文链表 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(9);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(9);

        ListNode node6=new ListNode(7);
        ListNode node7=new ListNode(6);
        ListNode node8=new ListNode(2);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        node6.next=node7;
        node7.next=node8;

        System.out.println(isPalindrome(node1));
        System.out.println(isPalindrome(node6));
        System.out.println(isPalindrome2(node1));
        System.out.println(isPalindrome2(node6));
    }
    //1. 空间复杂度为1 的切割翻转
    public static boolean isPalindrome2(ListNode head){
        if(head==null||head.next==null){
            return true;
        }
        //1.先获取到一半的字符串
        ListNode left=head;
        ListNode right=head.next;
        while(right!=null&&right.next!=null){
            left=left.next;
            right=right.next.next;
        }
        //right==null 意味着是奇数个 停止的时候left正好在中间数字上
        //如果是偶数个  需要调整left指向下一位方便切割
        if(right!=null){
            left=left.next;
        }
        //2.切割字符串
        cut(head,left);
        //3.翻转字符串
        ListNode newHead=reverse(left);
        //4.判断字符串
        while(newHead!=null&&head!=null){
            if(newHead.val!=head.val){
                return false;
            }
            newHead=newHead.next;
            head=head.next;
        }
        return true;

    }
    public static void cut(ListNode head,ListNode left){
        while(head.next!=left){
            head=head.next;
        }
        head.next=null;//断开
    }
    //头插法翻转
    public static ListNode reverse(ListNode head){
        ListNode newHead=null;
        while(head!=null){
            ListNode pnext=head.next;
            head.next=newHead;
            newHead=head;
            head=pnext;
        }
        return newHead;
    }
    //2. 栈
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode node=head;
        while(node!=null){
            stack.push(node.val);
            node=node.next;
        }
        while(head!=null&&!stack.isEmpty()){
            if(head.val==stack.pop()){
                head=head.next;
            }
        }
        if(head==null){
            return true;
        }else{
            return false;
        }
    }
}
