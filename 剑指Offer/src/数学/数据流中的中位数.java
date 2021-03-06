package 数学;

import java.util.PriorityQueue;

//如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
//如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
//使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
public class 数据流中的中位数 {
    PriorityQueue<Integer> MaxHeap=new PriorityQueue<>((o1,o2)->(o2-o1));
    PriorityQueue <Integer> MinHeap=new PriorityQueue<>((o1,o2)->(o1-o2));
    int count=0;//表示数字的个数
    public void Insert(Integer num) {
        if(count%2==0){
            MaxHeap.add(num);
            MinHeap.add(MaxHeap.poll());
        }else{
            MinHeap.add(num);
            MaxHeap.add(MinHeap.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2==0){
            return (MaxHeap.peek()+MinHeap.peek())/2.0;
        }else{
            //如果是奇数的话 因为奇数的时候要保存在小顶堆，所以取小顶堆最小值
            return (double)MinHeap.peek();
        }
    }

    public static void main(String[] args) {
        数据流中的中位数 a=new 数据流中的中位数();
        a.Insert(1);
        System.out.println(a.GetMedian());
        a.Insert(2);
        System.out.println(a.GetMedian());
        a.Insert(3);
        System.out.println(a.GetMedian());
        a.Insert(9);
        System.out.println(a.GetMedian());
        a.Insert(10);
        System.out.println(a.GetMedian());
        a.Insert(6);
        System.out.println(a.GetMedian());
    }
}
///*先用java集合PriorityQueue来设置一个小顶堆和大顶堆
//主要的思想是：因为要求的是中位数，那么这两个堆，大顶堆用来存较小的数，从大到小排列；
//小顶堆存较大的数，从小到大的顺序排序*，显然中位数就是大顶堆的根节点与小顶堆的根节点和的平均数。
//⭐保证：小顶堆中的元素都大于等于大顶堆中的元素，所以每次塞值，并不是直接塞进去，而是从另一个堆中poll出一个最大（最小）的塞值
//⭐当数目为偶数的时候，将这个值插入大顶堆中，再将大顶堆中根节点（即最大值）插入到小顶堆中；
//⭐当数目为奇数的时候，将这个值插入小顶堆中，再讲小顶堆中根节点（即最小值）插入到大顶堆中；
//⭐取中位数的时候，如果当前个数为偶数，显然是取小顶堆和大顶堆根结点的平均值；如果当前个数为奇数，显然是取小顶堆的根节点*/