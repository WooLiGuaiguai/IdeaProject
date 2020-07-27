package 贪心算法;

public class GA7 {
    public static void main(String[] args) {
        int []a={4,2,3};
        System.out.println(checkPossibility(a));

    }
    public static boolean checkPossibility(int[] nums) {
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<=nums[i]){
                continue;
            }
            count++;
            if((i-2)>=0&&nums[i-2]>nums[i]){
                nums[i]=nums[i-1];
            }else{
                nums[i-1]=nums[i];
            }
        }
        return count<=1;
    }
}
