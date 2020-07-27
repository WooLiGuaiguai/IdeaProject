package 二分查找;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//你的算法时间复杂度必须是 O(log n) 级别。
//如果数组中不存在目标值，返回 [-1, -1]。
//示例 1:
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//示例 2:
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]

public class 查找一个数字出现的区间 {
    public static void main(String[] args) {
        int []nums={5,7,7,8,8,10};
        int []result=searchRange(nums,8);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
    //可以用二分查找找出第一个位置和最后一个位置，但是寻找的方法有所不同，需要实现两个二分查找。
    //我们将寻找 target 最后一个位置，转换成寻找 target+1 第一个位置，再往前移动一个位置。这样我们只需要实现一个二分查找代码即可。
    public static int[] searchRange(int[] nums, int target) {
        int firloc=Index(nums, target);
        int secloc=Index(nums, target+1)-1;//比target大一的数字最先出现的位置减去一，就是target最后出现的位置
        if(firloc==nums.length||nums[firloc]!=target){//结束查找时有两种可能，返回了一个不存在的index  或者没找到该值
            return new int[]{-1,-1};
        }else{
            return new int[]{firloc,Math.max(firloc,secloc)};
        }
    }
    //需要注意这里right的取值  因为如果查找的比target大一点的数不存在，那么返回的是[0,nums.length-1]内的值
    //我们需要的是这个数字"插入"到数组之后的位置即nums.length 所以right的取值要注意
    //就好比[2,2]  查找target=2时，2+1=3，查找3应该返回的是index=2，这样减一之后index=1才是2出现的最后位置
    public static int Index(int []nums,int target){
        int left=0,right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){//第一次出现的target一定会在左区间
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    //上面的Index函数可以用来查找一个数字第一次出现的索引值
}
