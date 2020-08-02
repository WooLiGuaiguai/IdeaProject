package 数学;

public class 数组中三个数最大乘积 {
    public static void main(String[] args) {
        int []nums1={1,2,3,4};
        int []nums2={-5,-4,-2,-1};
        System.out.println(maximumProduct(nums1));
        System.out.println(maximumProduct(nums2));

    }
    public static int maximumProduct(int[] nums){
        if(nums.length<3){
            return 0;
        }
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;//保存最大的三个数 max1>max2>max3
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;//保存最小的两个数  这是因为考虑有可能是负数
        for (int num : nums) {
            if(num>max1){//大于最大的  那么max这三个数依次向后移动覆盖最小的
                max3=max2;
                max2=max1;
                max1=num;
            }else if(num>max2){
                max3=max2;
                max2=num;
            }else if(num>max3){
                max3=num;
            }
            //min2<min1
            if(num<min2){
                min1=min2;
                min2=num;
            }else if(num<min1){
                min1=num;
            }
        }
        return Math.max(max1*max2*max3,max1*min1*min2);
    }
}
