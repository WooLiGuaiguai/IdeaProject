package 排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Comp implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
/*在未排序的数组中找到第 k 个最大的元素。*/
public class px1 {
    public static void main(String[] args) {
        int []num1={3,2,1,5,6,4};
        int max=findKthLargest(num1,2);
        System.out.println(max);
        int max1=findKthLargest1(num1,2);
        System.out.println(max1);
        int max2=findKthLargest2(num1,2);
        System.out.println(max2);
    }
    //快排  时间复杂度 O(N)，空间复杂度 O(1)
    public static int findKthLargest2(int[] nums, int k){
        k=nums.length-k;
        int l=0;
        int h=nums.length-1;
        while(l<h){
            int j=partition(nums,l,h);
            if(j==k){
                break;
            }else if(j<k){
                l=j+1;
            }else{
                h=j-1;
            }
        }
        return nums[k];
    }
    private static int partition(int[] a, int l, int h){
        int i=l,j=h;
        while(true){
            while(a[++i]<a[l]&&i<h);
            while(a[j]>a[l]&&j>l){j--;}
            if(i>=j){break;}
            swap(a,i,j);
        }
        swap(a,l,j);
        return j;
    }
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    //小顶堆  第k个大的 也就是保留一个k大小的小顶堆，最后输出堆首  时间复杂度 O(NlogK)，空间复杂度 O(K)。
    public static int findKthLargest1(int[] nums, int k){
        Queue<Integer> queue=new PriorityQueue<>();
        for(int a:nums){
            queue.add(a);
            if(queue.size()>k){
                queue.poll();//1 2 3然后1出来 2 3 4然后2 出来  最后4 5 6 4出来 最上面就是5了
            }
        }
        return queue.peek();
    }
    //数组排序来完成 时间复杂度 O(NlogN)：二分查找最大的是logN 一共查找N次 空间复杂度 O(1)：在原数组上进行排序
    public static int findKthLargest(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

}
