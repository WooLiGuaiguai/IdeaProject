package 排序;

import java.util.Arrays;
import java.util.PriorityQueue;

/*在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
示例 1:
输入: [3,2,1,5,6,4] 和 k = 2  输出: 5
示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4  输出: 4
*/
public class kth_element {
    public static void main(String[] args) {
        int []num={3,2,1,5,6,4};
        System.out.println(findKthLargest2(num,2));
    }
    //3.快速选择 ：时间复杂度 O(N)，空间复杂度 O(1)

    //2.使用堆  时间复杂度 O(NlogK)，空间复杂度 O(K)。
    //用于求解 TopK Elements 问题，也就是 K 个最小元素的问题。
    //可以维护一个大小为 K 的最小堆，最小堆中的元素就是最小元素。最小堆需要使用大顶堆来实现，大顶堆表示堆顶元素是堆中最大元素
    //这是因为我们要得到 k 个最小的元素，因此当遍历到一个新的元素时，需要知道这个新元素是否比堆中最大的元素更小，
    //更小的话就把堆中最大元素去除，并将新元素添加到堆中。所以我们需要很容易得到最大元素并移除最大元素，大顶堆就能很好满足这个要求。
    //堆也可以用于求解 Kth Element 问题，得到了大小为 k 的最小堆之后，因为使用了大顶堆来实现，因此堆顶元素就是第 k 大的元素。
    public static int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> queue=new PriorityQueue<>();//小顶堆
        for (int num : nums) {
            queue.add(num);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
    //1.数组直接排序  时间复杂度 O(NlogN)，空间复杂度 O(1)
    public int findKthLargest1(int[] nums, int k){
        Arrays.sort(nums);
        return nums[k-1];
    }
}
