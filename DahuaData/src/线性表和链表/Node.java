package 线性表和链表;

public class Node {
    int data;//结点数据
    Node next=null;//指针域

    public Node(int data){
        this.data=data;
    }

    @Override
    public String toString() {
        return "Data:  "+data;
    }
}
