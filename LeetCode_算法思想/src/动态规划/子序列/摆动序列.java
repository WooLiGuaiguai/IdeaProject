package 动态规划.子序列;
//如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列,少于两个元素的序列也是摆动序列。
//例如，[1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
//给定一个整数序列，返回作为摆动序列的最长子序列的长度。
//通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。

public class 摆动序列 {
    public static void main(String[] args) {
        int []nums={1,7,4,9,2,5};
        int []a={1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));
        System.out.println(wiggleMaxLength(a));
    }
    public static int wiggleMaxLength(int[] nums){//1 7 4 9 2 5
        if (nums==null||nums.length==0){
            return 0;
        }
        int up=1,down=1;//标记的是上升点和下降点距离0的长度
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                up=down+1;
            }
            if(nums[i-1]>nums[i]){
                down=up+1;
            }
        }
        return Math.max(up, down);
    }

}
