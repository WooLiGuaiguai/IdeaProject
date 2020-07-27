package 二分查找;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//请找出其中最小的元素。
//示例 1:
//输入: [3,4,5,1,2]
//输出: 1
//示例 2:
//输入: [4,5,6,7,0,1,2]
//输出: 0
public class 寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        int[]a={3,4,5,1,2};
        int[]b={4,5,6,7,0,1,2};
        int[]c={3,2,2,2};
        int[]d={4,5,6,7,1,2,3,4,4,4};
        System.out.println(findMin(a));
        System.out.println(findMin(b));
        System.out.println(findMin(c));
        System.out.println(findMin(d));
    }
    public static int findMin(int[] nums){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }
}
