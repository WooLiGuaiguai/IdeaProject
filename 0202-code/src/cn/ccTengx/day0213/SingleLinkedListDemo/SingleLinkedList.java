package cn.ccTengx.day0213.SingleLinkedListDemo;

public class SingleLinkedList {
    //初始化一个头结点
    private Hero head=new Hero(0,"","");
    //添加结点方法  直接添加到链表最后面
    public void add(Hero node){
        //因为头结点不能动 所以添加一个辅助结点
        Hero temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
    }
    //添加结点方法二  根据number将结点添加到指定的位置
    public void add2(Hero node){
        Hero temp=head;
        boolean flag=false;//用来判断结点是否已经存在
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.number>node.number){
                break;
            }else if(temp.next.number==node.number){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            System.out.println("需要插入的节点已经存在");
        }else{
            node.next=temp.next;
            temp.next=node;
        }
    }
    //添加结点三  将节点添加到第k个位置上
    public void add3(Hero node,int index){
        if(head==null){return ;}
        Hero temp=head;
        int key=0;//用来标记第几个
        while(temp.next!=null && key<index-1){
            key++;
            temp=temp.next;
        }
        if(temp.next==null){
            temp.next=node;//如果结束循环的时候是由于链表长度不够 那么直接放在链表尾部
        }else{
            //如果是因为key==index
            node.next=temp.next;
            temp.next=node;
        }

    }
    //删除节点
    public void delete(Hero node){
        Hero temp=head;
        boolean flag=false;
        if(temp==null){
            return ;
        }
        while(true){
            if(temp.next==null){
                break;
            }else if(temp.next.name==node.name){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            temp.next=temp.next.next;
        }else{
            System.out.println("结点不存在");
        }
    }

    //显示遍历链表
    public void list(){
        Hero temp=head;
        if(head==null){
            System.out.println("链表为空");
            return;
        }
        while(temp.next!=null){
            System.out.println(temp.next);
            temp=temp.next;
        }
    }

}
