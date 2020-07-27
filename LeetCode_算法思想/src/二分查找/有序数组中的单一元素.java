package 二分查找;
//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
//输入: [1,1,2,3,3,4,4,8,8]
//输出: 2

//输入: [3,3,7,7,10,11,11]
//输出: 10
//注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。

public class 有序数组中的单一元素 {
    public static void main(String[] args) {
        int []nums={1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            boolean flag=false;//用来标记去掉mid后右侧个数是否为偶数
            if((right-mid)%2==0){
                flag=true;//右侧个数是偶数
            }
            if(nums[mid]==nums[mid-1]){
                if(flag){//如果右边是偶数，那么要找的值一定在左边
                    right=mid-2;
                }else{
                    left=mid+1;
                }
            }else if(nums[mid]==nums[mid+1]){
                if (flag){//右边存在一个重复的 且右边为偶数，那么要查找的值在右边
                    left=mid+2;
                }else{
                    right=mid-1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[right];
    }
}
