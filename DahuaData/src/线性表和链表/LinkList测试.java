package 线性表和链表;

public class LinkList测试 {
    public static void main(String[] args) {
        LinkList<Integer> nums = new LinkList<Integer>();
        nums.isEmpty();
        System.out.println("——————————插入1到5,并读取内容——————————");
        for (int i = 0; i <= 5; i++)
            nums.insertNode(i, 2*i);//0 2 4 6 8 10
        nums.isEmpty();
        int num;
        System.out.println("——————————查找0、2、9是否在表中——————————");
        System.out.print("0的位置：");
        System.out.println(nums.indexItem(0));
        System.out.print("2的位置：");
        System.out.println(nums.indexItem(2));
        System.out.print("10的位置：");
        System.out.println(nums.indexItem(9));
        System.out.println("——————————删除2、10——————————");
        nums.deleteNode(1);
        nums.deleteNode(5);

        for (int i = 0; i < nums.ListLength(); i++) {
            num = nums.findNode(i);
            System.out.println("第" + i + "个位置的值为：" + num);
        }
    }
}
