package 数组;
//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
//使用双指针，如果num[i]==num[j] 仅仅j++就可以  如果 num[i]!=num[j]  使用num[j]覆盖重写num[i++]
public class 删除排序数组重复项 {
    public static int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int []nums={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
