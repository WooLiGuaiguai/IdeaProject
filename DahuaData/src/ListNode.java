public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println(deleteDuplicates(node1));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pnext=head;
        while(pnext!=null&&pnext.next!=null){
            if(pnext.val==pnext.next.val){
                pnext.next=pnext.next.next;
            }else{
                pnext=pnext.next;
            }
        }
        return head;
    }
}
