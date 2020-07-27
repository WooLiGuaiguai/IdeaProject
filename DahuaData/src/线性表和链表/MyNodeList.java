package 线性表和链表;

public class MyNodeList {
    private Node head=new Node(0);//初始化头结点
    public MyNodeList(){

    }
    //添加结点方法1：直接添加到链表最后面
    public void add(Node node){
        Node temp=head;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
    }
    //添加结点方法2:  根据value值将结点添加到指定的位置
    public void add2(Node node){
        Node temp=head;
        boolean flag=false;//用来判断是否存在
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.data==node.data){
                flag=true;
                break;
            }else if(temp.next.data>node.data){
                break;
            }
            temp=temp.next;
        }
        //跳出的时候判断是已经存在还是超过给定数值
        if(flag){
            System.out.println("已经存在");
        }else{
            node.next=temp.next;
            temp.next=node;
        }
    }
    //添加结点三  将节点添加到第k个位置上
    public void add3(Node node,int index){
        Node temp=head;
        int i=0;
        while(temp.next!=null&&i<index){
            temp=temp.next;
            i++;
        }
        if(temp.next==null){
            temp.next=node;
        }else{
            node.next=temp.next;
            temp.next=node;

        }
    }
    //删除结点：
    public void delete(int index){
        Node temp=head;
        boolean flag=false;
        int i=0;
        if(temp==null){
            return;
        }
        while(true){
            if(temp.next==null){//长度不够
                break;
            }
            if((i+1)==index){
                flag=true;
                break;
            }
            temp=temp.next;
            i++;
        }
        if(flag==true){
            temp.next=temp.next.next;
        }else{
            System.out.println("结点不存在");
        }
    }
    public boolean deleteNode(int index){
        if(index<1 ){//待删除结点不存在
            return false;
        }
        if(index == 1){//删除头结点
            head = head.next;
            return true;
        }
        Node preNode = head;
        Node curNode = preNode.next;
        int i = 1;
        while(curNode != null){
            if(i==index){//寻找到待删除结点
                preNode.next = curNode.next;//待删除结点的前结点指向待删除结点的后结点
                return true;
            }
            //当先结点和前结点同时向后移
            preNode = preNode.next;
            curNode = curNode.next;
            i++;
        }
        return true;
    }
    //单链表获取第i个数据
    public Node GetElem(int i){
        if(i<1){
            return null;
        }
        Node node=head;
        for(int j=0;j<=i-1;j++){
            if(node.next!=null){
                node=node.next;
            }else{
                return null;
            }
        }
        return node;
    }
    //头插法创建结点
    public void CreateListHead(int data){
        Node node=new Node(data);
        if(this.head==null){//如果没有头结点
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }
    }
    //尾插法
    public void CreateListTail(int data) {
        Node node=new Node(data);
        Node cur=this.head;
        if (this.head==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    //显示遍历链表
    public void list(){
        Node temp=head;
        if(temp==null){
            System.out.println("链表为空");
        }
        while(temp.next!=null){
            System.out.print(temp+"    ");
            temp=temp.next;
        }
    }
}
