package 数组;

import java.util.PriorityQueue;

/*给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。*/
public class 寻找两个正序数组的中位数 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> MaxHeap=new PriorityQueue<>((o1,o2)->(o2-o1));
        PriorityQueue<Integer> MinHeap=new PriorityQueue<>((o1,o2)->(o1-o2));
        int count=0;//数字的个数
        int len1=nums1.length,len2=nums2.length;
        for(int i=0;i<len1;i++){
            if(count%2==0){
                MaxHeap.add(nums1[i]);
                MinHeap.add(MaxHeap.poll());
            }else{
                MinHeap.add(nums1[i]);
                MaxHeap.add(MinHeap.poll());
            }
            count++;
        }
        for(int i=0;i<len2;i++){
            if(count%2==0){
                MaxHeap.add(nums2[i]);
                MinHeap.add(MaxHeap.poll());
            }else{
                MinHeap.add(nums2[i]);
                MaxHeap.add(MinHeap.poll());
            }
            count++;
        }
        if(count%2!=0){
            return MinHeap.peek();
        }else{
            return (double)(MinHeap.peek()+MaxHeap.peek())/2;
        }
    }

    public static void main(String[] args) {
        int []nums1 = {1,2};
        int []nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));

        int []nums3 = {1,3};
        int []nums4 = {2};
        System.out.println(findMedianSortedArrays(nums3,nums4));
    }
}
