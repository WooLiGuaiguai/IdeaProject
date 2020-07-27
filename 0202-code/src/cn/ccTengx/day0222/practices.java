package cn.ccTengx.day0222;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class practices {
    private static PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;//优先先返回最大的结点  大顶堆
        }
    });
    //默认是升序的也就是o1-o2  下面重写是为了使用lambda表达式
    private static PriorityQueue<Integer> MinHeap = new PriorityQueue<Integer>((o1,o2)->{return o1-o2;});
    static int count=0;//
    public static void main(String[] args) {
        Integer [] arr={1,2,3,8,7,4,5};
        for (Integer i:arr) {
            Insert(i);
        }
        System.out.println(GetMedian());
        int [][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list=printMatrix(matrix);
        System.out.println(list);
    }
    public static void Insert(Integer val){
        if(count%2==0){//如果已经添加的个数是偶数
            MaxHeap.add(val);//放到大顶堆MaxHeap 自动排序
            MinHeap.add(MaxHeap.poll());//将大顶堆最大的取出来放到小顶堆
        }else{
            MinHeap.add(val);//放到小顶堆MinHeap 自动排序
            MaxHeap.add(MinHeap.poll());//最小的取出来给了大顶堆
        }
        count++;
    }
    //插入完成 大顶堆全部小于小顶堆
    public static  Double GetMedian(){
        //如果是偶数个那么大顶堆第一个和小顶堆第一个就是最小的两个
        if(count%2==0){
            return (double)(MaxHeap.peek()+MinHeap.peek())/2;
        }//如果是奇数个 那么添加之前是偶数 先到大顶堆 后到小顶堆 所以从小顶堆取
        else{
            return (double)MinHeap.peek();
        }
    }
    public static ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> list=new ArrayList<>();
        //全部取坐标来做
        int r=0,row=matrix.length-1,c=0,col=matrix[0].length-1;
        while(r<=row && c<=col){
            for(int i=c;i<=col;i++){
                list.add(matrix[r][i]);
            }
            for(int i=r+1;i<=row;i++){
                list.add(matrix[i][col]);
            }
            if(r!=row){
                for(int i=col-1;i>=c;i--){
                    list.add(matrix[row][i]);
                }
            }
            if(c!=col){
                for (int i=row-1;i>r;i--){
                    list.add(matrix[i][c]);
                }
            }
            r++;row--;
            c++;col--;
        }
        return list;
    }
}
