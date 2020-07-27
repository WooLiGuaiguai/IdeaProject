package 哈希表;

import java.util.HashSet;
import java.util.Set;

public class 重复元素 {//判断是否不存在重复元素
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9};

        int []brr={1,2,3,1};
        System.out.println(containsDuplicate(arr));
        System.out.println(containsDuplicate(brr));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        return set.size()==nums.length;
    }
}
