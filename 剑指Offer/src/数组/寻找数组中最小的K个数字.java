package 数组;
//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 寻找数组中最小的K个数字 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        if(input==null||input.length<k){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> MaxHeap=new PriorityQueue<>((o1,o2)->(o2-o1));
        for(int i=0;i< input.length;i++){
            MaxHeap.add(input[i]);
            if(MaxHeap.size()>k){
                MaxHeap.poll();
            }
        }
        return new ArrayList<>(MaxHeap);
    }

    public static void main(String[] args) {
        int []input={4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(input,4));
    }
}
