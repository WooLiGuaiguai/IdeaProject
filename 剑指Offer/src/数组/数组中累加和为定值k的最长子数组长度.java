package 数组;

import java.util.HashMap;
import java.util.HashSet;

public class 数组中累加和为定值k的最长子数组长度 {
    public static void main(String[] args) {
        int [] arr={4,1,2,5,1,1,1,1,1};
        System.out.println(getMaxLength(arr,10));
        int []arr2={-6,5,-4,10,-2,-4,-4,7};
        System.out.println(getMaxLength2(arr2,0));
    }
    //数组中都是正整数
    public static int getMaxLength(int[] arr, int k){
        if(arr==null||arr.length==0||k<0){
            return 0;
        }
        int left=0,right=0;
        int sum=arr[0];
        int len=0;
        while(right<arr.length){
            if(sum==k){
                len=Math.max(len,right-left+1);
                sum=sum-arr[left++];
            }else if(sum<k){
                right++;
                if(right==arr.length){
                    break;
                }
                sum=sum+arr[right];
            }else{
                sum=sum-arr[left++];
            }
        }
        return len;
    }

    //数组中有正数也有负数和0
  /*例如数组arr的下标为：0...i...j...n-1,求出以0位置开始，任意位置j结束的子数组和sum。
  假设0位置开始，任意位置i结束的子数组和temp，如果存在sum-temp==k，那么i+1...j位置即为所求子数组。
  为了保证该子数组最长，我们在j位置不变的情况下，需要使i位置出现的尽量靠前。
  引用一个结构hashmap来保存，key为子数组的和，value为此时子数组结尾元素的位置。
  根据hashmap的特性key唯一，后出现的temp不会被更新value，也就确保了temp出现的位置尽量靠前
  注意：因为所求子数组是i+1...j位置，为了保证第0位置的元素不被忽略，必须加上map.put(0, -1);

    例如arr=[2,3,5,4]，k=14，
    i=0：sum=2,temp=2-14=-12,map中不存在key==-12的，此时保存map(2,0);
    i=1：sum=5,temp=5-14=-9,map中不存在key==-9的,此时保存map(5,1);
    i=2：sum=10,temp=10-14=-4,map中不存在key==--4的，此时保存map(10,2);
    i=3：sum=14,temp=14-14=0,map中存在key==0的，此时len=3-（-1）=4
    如果没有map.put(0, -1); 当i=3时，map中找不到key==0，此时就会返回len=0，而此数组并非无解。
    时间复杂度：遍历整个数组一遍，所以为O(n)*/
    public static int getMaxLength2(int []arr,int k){
        if(arr==null||arr.length==0){
            return 0;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int len=0,sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                len=Math.max(len,i-map.get(sum-k));
            }
            if(!map.containsKey(sum-k)){
                map.put(sum,i);
            }
        }
        return len;
    }
}
