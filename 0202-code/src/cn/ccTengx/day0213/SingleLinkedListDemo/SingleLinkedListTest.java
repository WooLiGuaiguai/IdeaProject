package cn.ccTengx.day0213.SingleLinkedListDemo;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        //进行测试
        //先创建结点
        Hero hero1=new Hero(1,"宋江","及时雨");
        Hero hero2=new Hero(4,"卢俊义","玉麒麟");
        Hero hero3=new Hero(3,"吴用","智多星");
        Hero hero4=new Hero(9,"林冲","豹子头");
        Hero hero5=new Hero(3,"吴用","智多星");
        Hero hero6=new Hero(7,"lisa","蜘蛛精");
        //创建链表
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero5);
        singleLinkedList.list();

        System.out.println("根据number的值将结点插入到指定的位置");
        SingleLinkedList singleLinkedList2=new SingleLinkedList();
        singleLinkedList2.add2(hero1);
        singleLinkedList2.add2(hero2);
        singleLinkedList2.add2(hero3);
        singleLinkedList2.add2(hero4);
        singleLinkedList2.list();
        singleLinkedList2.add2(hero4);


        System.out.println("将结点插入到指定索引上,插入前：");
        singleLinkedList.list();
        singleLinkedList.add3(hero6,6);
        System.out.println("将结点插入到指定索引上,插入后：");
        singleLinkedList.list();
        System.out.println("删除第一个结点：");
        singleLinkedList.delete(hero1);
        singleLinkedList.list();
        System.out.println("删除最后一个结点：");
        singleLinkedList.delete(hero6);
        singleLinkedList.list();
    }

}
