package 双指针;
/*给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。*/
//关键在于是向一个数组中添加，所以应该从最后面开始添加
public class 合并两个有序数组 {
    public static void main(String[] args) {
        int []nums1 = {1,2,3,4,9,0,0,0};
        int []nums2 = {2,5,6};
        merge(nums1,5,nums2,3);
        for (int i : nums1) {
            System.out.print(i+" ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int index=m+n-1;//遍历开始的坐标
        int i=m-1,j=n-1;
        while(i>=0||j>=0){
            if(i>=0 && j>=0){
                nums1[index--]=(nums1[i]>nums2[j])?nums1[i--]:nums2[j--];
            }else if(i>=0){//第一个数组还有余下的数字
                nums1[index--]=nums1[i--];
            }else {
                nums1[index--]=nums2[j--];
            }
        }
    }
}
