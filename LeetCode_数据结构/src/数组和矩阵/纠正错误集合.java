package 数组和矩阵;
/*集合 S 包含从1到 n 的整数。因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值
导致集合丢失了一个整数并且有一个元素重复。
给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
*/
public class 纠正错误集合 {
    public static void main(String[] args) {
        int []nums={1,2,2,4};
        int []nums1={1,5,9,4,6,2,8,7,7};
        int []ans=findErrorNums(nums1);
        for (int an : ans) {
            System.out.print(an+" ");
        }

    }
    //主要思路是先将每个数字放到应该的位置上  然后再进行查找
    public static int[] findErrorNums(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){
                //进行位置变动的条件是nums[i]上没有放i+1 并且nums[i]应该放的位置上放的也不是它的值
                swap(nums,i,nums[i]-1);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){//返回的条件是nums[i]上没有放i+1
                return  new int[]{nums[i],i+1};
            }
        }
        return null;
    }
    public static void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
