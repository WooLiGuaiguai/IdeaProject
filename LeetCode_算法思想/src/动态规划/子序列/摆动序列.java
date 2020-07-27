package 动态规划.子序列;

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
