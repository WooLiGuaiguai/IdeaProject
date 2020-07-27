package 数组和矩阵;

import java.util.PriorityQueue;

/*给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。*/
public class 有序数组中第k小的元素 {
    public static void main(String[] args) {

    }
    //使用堆排序实现
    public static int kthSmallest(int[][] matrix, int k){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        PriorityQueue<Tuple> queue=new PriorityQueue<>();
        for(int j=0;j<n;j++){
            queue.offer(new Tuple(0,j,matrix[0][j]));
        }
        for(int i=1;i<=k-1;i++){//去除掉k-1个元素  那么堆顶就是第k小了
            Tuple key=queue.poll();
            if(key.x==m-1){//到最后一行  不必再加 结束循环
                continue;
            }
            queue.offer(new Tuple(key.x+1,key.y,matrix[key.x+1][key.y]));//把下一行的添加进来
        }
        return queue.poll().val;
    }
    static class Tuple implements Comparable<Tuple>{
        int x,y,val;
        public Tuple(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
        @Override
        public int compareTo(Tuple o) {//最小堆
            return this.val-o.val;
        }
    }
    //使用二分法查找
    public static int kthSmallest1(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int low=matrix[0][0];
        int high=matrix[m-1][n-1];
        while(low<=high){
            int mid=low+(high-low)/2;
            int count=0;//统计个数 与k进行比较
            for(int i=0;i<m;i++){
                for(int j=0;j<n&&matrix[i][j]<=mid;j++){
                    count++;
                }
            }
            if(count<k){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return low;
    }
}
