package 线性表和链表;

public class MyNodeListTest {
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        //链表的初始化
        MyNodeList myNodeList=new MyNodeList();
        myNodeList.add(node1);
        myNodeList.add(node2);
        myNodeList.add(node5);
        myNodeList.add2(node3);
        myNodeList.add3(node7,1);
        myNodeList.list();
        System.out.println();
        //获取指定位置元素
        System.out.println(myNodeList.GetElem(3));
        //删除元素
        System.out.println("测试删除：");
        myNodeList.delete(4);
        myNodeList.list();
        System.out.println();
        //测试头插法
        System.out.println("测试头插法");
        myNodeList.CreateListHead(12);
        myNodeList.list();
        System.out.println();
        //测试尾插法
        System.out.println("测试尾插法");
        myNodeList.CreateListTail(12);
        myNodeList.list();
    }
}
