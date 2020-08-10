package 数学;
//Boyer-Moore 投票算法
//思路
//如果我们把众数记为 +1，把其他数记为 −1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
//
//算法
//维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
//我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
//如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
//如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
//在遍历完成后，candidate 即为整个数组的众数。
//
//[7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
//在遍历到数组中的第一个元素以及每个在 | 之后的元素时，candidate 都会因为 count 的值变为 0 而发生改变。
//最后一次 candidate 的值从 5 变为 7，也就是这个数组中的众数。

public class 投票问题 {
    public static int majorityElement(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        int candidate=nums[0];
        int count=1;
        for (int i=1;i<nums.length;i++) {
            if(candidate==nums[i]){
                count++;
            }else {
                count--;
            }
            if(count==0){
                candidate=nums[i];
                count=1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int []nums={7, 7, 5, 7, 5, 1 , 5, 7 , 5, 5, 7, 7 , 7, 7, 7, 7};
        int []nums1={1,1,1,2,3,3,3};
        int []nums3={1,2,2,2,2,3,3,3,3,4,5};//1,2,3,2,4,2,5,2,3

        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(nums1));
        System.out.println(majorityElement(nums3));
    }
}
