package 数组;

class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                 val = x;
                 next = null;
             }
  }
public class sz7 {
    public boolean hasCycle(ListNode head){
        if(head==null){
            return false;
        }
        ListNode left=head;
        ListNode right=head.next;
        while(left!=null&&right!=null&&right.next!=null){
            if(left==right){
                return true;
            }
            left=left.next;
            right=right.next.next;
        }
        return false;
    }
}
