package Util;

public class ListNode {
    public int val;//结点数据
    public ListNode next=null;//指针域

    public ListNode(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return ""+val;
    }
}
