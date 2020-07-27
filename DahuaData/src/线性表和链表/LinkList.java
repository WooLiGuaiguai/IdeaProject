package 线性表和链表;
//链表
public class LinkList<E> {
    private Node<E> head;//链表头结点
    private int count;//链表长度

    private class Node<E>{
        E data;
        Node<E> next;
        public Node(E data,Node<E>next){
            this.data=data;
            this.next=next;
        }
    }
    //链表初始化
    public LinkList(){
        head=new Node<E>(null,null);
        count=0;
    }
    //判断是否为空
    public boolean isEmpty(){
        if(count==0){
            System.out.println("表为空");
            return true;
        }else{
            System.out.println("表不为空");
            return false;
        }
    }
    //查找第i个结点
    public E findNode(int i){
        if(i>=count){
            throw new RuntimeException("下标错误");
        }else if(i==0){
            return head.data;
        }else{
            Node<E> node=head;
            for (int j=0;j<i;j++){
                node=node.next;
            }
            return node.data;
        }
    }
    //查找元素
    public int indexItem(E e){
        Node<E> node=head.next;
        if(node.data==e){
            return 1;
        }
        for (int i=1;i<count;i++){
            node=node.next;
            if(node.data==e){
                return i+1;
            }
        }
        System.out.println("查找失败");
        return 0;
    }
    //第i个位置插入元素
    public void insertNode(int index,E e){
        if(index<0||index>=count){
            System.out.println("下标不正确");
            return;
        }else{
            Node<E> newNode=new Node<>(e,null);
            Node<E> node=head;
            for(int i=0;i<index-1;i++){//找第i-1个结点
                node=node.next;
            }
            newNode.next=node.next;
            node.next=newNode;
            count++;
            System.out.println("插入成功");
        }
    }
    //删除第i个结点
    public Node<E> deleteNode(int index){
        if(index<0||index>=count){
            System.out.println("下标不正确");
            return null;
        }else{
            Node<E> node=head;
            for(int i=0;i<index-1;i++){//找第i-1个结点
                node=node.next;
            }
            node.next=node.next.next;
            count--;
            System.out.println("删除成功");
        }
        return head;
    }
    public int ListLength() {
        return count;
    }
}
