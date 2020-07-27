package 排序;

public class px2 {
    public static void main(String[] args) {
        int[]num1={0 ,1, 2, 1, 2, 0, 1, 0};
        sortColors(num1);
        for (int i : num1) {
            System.out.print(i+" ");
        }
    }
    public static void sortColors(int[] nums){
        int i=0;//遍历指针
        int zero=0,two=nums.length;//一个保存0区间 一个保存2区间   顺序 0  1  2
        while(i<two)//当i移动到2的边界时 右侧都是2了  停止
        {//0 1 2 1 2 0 1 0
            /*编码的时候，zero 和 two 初始化的值就应该保证上面的三个子区间全为空。
            在遍历的过程中，“索引先加减再交换”、还是“先交换再加减”就看初始化的时候变量在哪里。
            退出循环的条件也看上面定义的循环不变量，在 i == two 成立的时候，
            上面的三个子区间就正好“不重不漏”地覆盖了整个数组，并且给出的性质成立，题目的任务也就完成了。*/
            if(nums[i]==0){
                swap(nums,zero,i);
                zero++;
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                two--;
                swap(nums,i,two);
            }
        }

    }
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
