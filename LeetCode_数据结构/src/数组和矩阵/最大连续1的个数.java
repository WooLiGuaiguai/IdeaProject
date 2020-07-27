package 数组和矩阵;

public class 最大连续1的个数 {
    public static void main(String[] args) {
        int []numss={1,0,0,0,1,1,1,1,0,1,0,1,0};
        System.out.println(findMaxConsecutiveOnes(numss));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int curlen=0;
        int maxlen=0;
        for (int num : nums) {
            if(num==0){
                curlen=0;
            }else{
                curlen=curlen+1;
            }
            maxlen=Math.max(maxlen,curlen);
        }
        return maxlen;
    }
}
