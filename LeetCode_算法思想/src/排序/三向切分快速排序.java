package 排序;
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

//示例:
//输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]

public class 三向切分快速排序 {
    public static void main(String[] args) {
        int[] num={0,1,0,1,2,0,1,1,2,0,1,2,0,1};
        sortColors(num);
        for (int i : num) {
            System.out.print(i+" ");
        }
    }
    public static void sortColors(int[] nums){
        int i=0;//用来遍历的指针
        int zero=0,two=nums.length-1;//用来划分区间 0  1  2  zero表示第一个不是0的数字 two表示最后一个1
        while(i<two){
            if(nums[i]==0){
                swap(nums,zero,i);
                zero++;
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                swap(nums,i,two);
                two--;
            }
        }
    }
    public static  void swap(int []num,int i,int j){
        int tmp=num[i];
        num[i]=num[j];
        num[j]=tmp;
    }
}
