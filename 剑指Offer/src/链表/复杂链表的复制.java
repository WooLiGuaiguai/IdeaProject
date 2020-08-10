package 链表;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点）
// 请对此链表进行深拷贝，并返回拷贝后的头结点
public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead){//1--2--3--4
        if(pHead==null){
            return pHead;
        }
        RandomListNode pNext=pHead;//用来移动的指针结点
        //首先遍历链表  实现链表新节点的插入  1--1--2--2--3--3--4--4
        while(pNext!=null){
            RandomListNode node=new RandomListNode(pNext.label);
            node.next=pNext.next;
            pNext.next=node;
            pNext=node.next;
        }
        //对结点的random属性进行赋值
        pNext=pHead;
        while(pNext!=null){
            RandomListNode node=pNext.next;//新加入的结点
            if(pNext.random!=null){
                node.random=pNext.random.next;
            }
            pNext=node.next;
        }
        //将原链表拆下来
        pNext=pHead;
        RandomListNode newHead=pNext.next;
        while(pNext!=null){
            RandomListNode node=pNext.next;
            pNext.next=node.next;//将新复制出来的结点从原链表断开
            if(node.next!=null){
                node.next=node.next.next;//将下一个复制出来的结点连接在前一个复制结点上面
            }
            pNext=pNext.next;
        }
        return newHead;
    }
}
