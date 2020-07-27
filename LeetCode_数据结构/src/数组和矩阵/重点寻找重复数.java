package 数组和矩阵;
/*给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
不能更改原数组（假设数组是只读的）。
只能使用额外的 O(1) 的空间。
时间复杂度小于 O(n2) 。
数组中只有一个重复的数字，但它可能不止重复出现一次。*/
public class 重点寻找重复数 {
    public static void main(String[] args) {
        int []arr={1,7,6,5,3,2,4,4};
        System.out.println(findDuplicate1(arr));
    }
    //双指针查找法
    public static int findDuplicate1(int []nums){
        int slow=nums[0];
        int fast=nums[nums[0]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
    //二分查找法分析
    //假设重复的数字是target，且重复两次，count保存数组中小于等于某个数的个数
    //因为是从1-n里面取n+1个值，所以如果从[1,target-1]里面取，count[i]的值是i,通用条件是小于等于i
    //如果从[target,n]里面取，count[i]的值是i+1 通用条件是大于i
    //如果重复的数字是重复了不止两次，count和上面含义一样，这时候实际上是target替代了
    //如果替代的数字比target小，那么如果从[1,target-1]里面取，[1,i-1]的count值不变，[i,target-1]的count减一
    //如果替代的数字比target大，那么如果从[target,n]里面取，[target,i]的count值加一，[i,n]的count不变
    public static int findDuplicate(int[] nums) {//12344567
        int low=1,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid){
                    count++;
                }
            }
            if(count>mid){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
