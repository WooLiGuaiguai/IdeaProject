package 数组;
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//双指针
//如果查找到的元素不是val 那么i和j应该会保持相同移动  如果是val只有j移动，可以想象成随着i移动在刷新数组
public class 移除给定元素 {
    public static int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int []nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums,val));
    }
}
