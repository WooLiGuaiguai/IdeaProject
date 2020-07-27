package 双指针;
/*给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
*/
public class 有序数组的两个数字和 {
    public static void main(String[] args) {
        int []num={2, 7, 11, 15};
        int []result=twoSum(num,9);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers==null){
            return null;
        }
        int left=0,right=numbers.length-1;
        while(left<right){
            if(numbers[left]+numbers[right]==target){
                return new int[]{left+1,right+1};
            }else if(numbers[left]+numbers[right]>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[2];
    }
}
