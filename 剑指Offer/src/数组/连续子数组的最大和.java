package 数组;
//计算连续子向量的最大和,例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
//给一个数组，返回它的最大连续子序列的和(子向量的长度至少是1)
public class 连续子数组的最大和 {
    public static int FindGreatestSumOfSubArray(int[] array){
        if(array==null||array.length==0){
            return 0;
        }
        int maxsum=Integer.MIN_VALUE;//最大和
        int cursum=0;//当前的和
        for(int i=0;i<array.length;i++){
            cursum=(cursum>0) ? cursum+array[i] :array[i];
            maxsum=Math.max(cursum,maxsum);
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int []num={6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(num));
    }
}
