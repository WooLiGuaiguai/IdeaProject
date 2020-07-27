package 线性表和链表;

public class SqList测试 {
    public static void main(String[] args) {
        SqList<Integer> list=new SqList<>(5);
        list.IsEmpty();
        System.out.println("——————————插入1到5,并读取内容——————————");
        for(int i=0;i<5;i++)
            list.InsertList(i, i);
        list.IsEmpty();
        int num;
        for(int i=0;i<5;i++) {
            num=list.GetItem(i);
            System.out.println("第"+i+"个位置的值为："+num);
        }
        System.out.println("——————————查找0、1、5是否在表中——————————");
        System.out.print("0的位置：");
        System.out.println(list.LocateItem(0));
        System.out.print("1的位置：");
        System.out.println(list.LocateItem(1));
        System.out.print("5的位置：");
        System.out.println(list.LocateItem(5));
        System.out.println("——————————删除2、5——————————");
        num=list.ListDelete(2);
        System.out.println("已删除："+num);
        num=list.ListDelete(4);
        System.out.println("已删除："+num);
        System.out.println("当前表长："+list.ListLength());
        for(int i=0;i<list.ListLength();i++) {
            num=list.GetItem(i);
            System.out.println("第"+i+"个位置的值为："+num);
        }
        list.ClearList();
        list.IsEmpty();
    }
}
