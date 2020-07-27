package 贪心算法;
//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//
//我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

public class 非递减数列 {
    public static void main(String[] args) {
        int []num={4,2,1};
        System.out.println(checkPossibility(num));
    }
    public static boolean checkPossibility(int[] nums){
        int count=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i-1]<=nums[i]){
                continue;
            }
            count++;//这里意味着存在一个递减 count++
            //在出现 nums[i] < nums[i - 1] 时，需要考虑的是应该修改数组的哪个数，使得本次修改能使 i 之前的数组成为非递减数组，并且 不影响后续的操作
            // 优先考虑令 nums[i - 1] = nums[i]，因为如果修改 nums[i] = nums[i - 1] ，那么 nums[i] 会变大，有可能比 nums[i + 1] 大，从而影响后续操作
            // 还有一个比较特别的情况就是 nums[i] < nums[i - 2]，修改 nums[i - 1] = nums[i] 不能使数组成为非递减数组，只能修改 nums[i] = nums[i - 1]
            if ((i-2>=0) && nums[i-2]>nums[i]){//3 2 1修改成为2 2 1，这时候如果继续按照前面的套路改i-1上的数字 会变成2 1 1 还是递减
                nums[i]=nums[i-1];
            }else{
                nums[i-1]=nums[i];
            }
        }
        return count<=1;
    }

}
