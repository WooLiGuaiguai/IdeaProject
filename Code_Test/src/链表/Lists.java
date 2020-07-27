package 链表;

public class Lists {
    //初始化一个头结点
    private ListNode head=new ListNode(0);
    //添加结点方法  直接添加到链表最后面
    public void add(ListNode node){
        //因为头结点不能动 所以添加一个辅助结点
        ListNode temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
    }
    public void list(){
        ListNode temp=head;
        if(head==null){
            System.out.println("链表为空");
            return;
        }
        while(temp.next!=null){
            System.out.print(temp.next.val+"->");
            temp=temp.next;
        }
    }
}
