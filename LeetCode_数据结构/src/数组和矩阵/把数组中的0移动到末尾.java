package 数组和矩阵;
/*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。*/
public class 把数组中的0移动到末尾 {
    public static void main(String[] args) {
        int []nums=new int[]{0,1,3,0,12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
    public static void moveZeroes(int[] nums) {//先将不是0的数字填充进去 后面直接置0
        int index=0;//用来保存下标
        for (int num : nums) {
            if(num!=0){
                nums[index]=num;
                index++;
            }
        }
        while(index<nums.length){
            nums[index]=0;
            index++;
        }
    }
}
