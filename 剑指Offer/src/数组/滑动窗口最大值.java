package 数组;

import java.util.ArrayList;
import java.util.PriorityQueue;

//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
// 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3
//针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
//{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
//窗口大于数组长度的时候，返回空
public class 滑动窗口最大值 {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list=new ArrayList<>();
        if(num.length<size||size<1){
            return list;
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2) -> (o2-o1));
        //首先添加第一个区间
        for(int i=0;i<size;i++){
            queue.add(num[i]);
        }
        list.add(queue.peek());
        //然后向后移动区间，分别取最大值
        for (int j=0,i=size;i<num.length;j++,i++){
            queue.remove(num[j]);
            queue.add(num[i]);
            list.add(queue.peek());
        }
        return list;
    }
}
