package 搜索.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集问题 {
    //给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        for(int size=0;size<=nums.length;size++){//对每个size的集合都进行添加
            Back_togetChild(lists,list,size,0,nums);//因为一个子集中不存在重复选取数字 所以要设置start位
        }
        return lists;
    }
    public static void Back_togetChild(List<List<Integer>> lists,List<Integer> list,int size,int start,int []nums){
        if(list.size()==size){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            Back_togetChild(lists,list,size,i+1,nums);//每次都要向后移动
            list.remove(list.size()-1);
        }
    }
    //给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）  说明：解集不能包含重复的子集。
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean []flag=new boolean[nums.length];//为每个数字设置标志位
        Arrays.sort(nums);
        for (int size=0;size<=nums.length;size++){
            Back_togetChild2(lists,list,size,flag,0,nums);
        }
        return lists;
    }
    public static void Back_togetChild2(List<List<Integer>> lists,List<Integer> list,int size,boolean[]flag,int start,int []nums){
        if(list.size()==size){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1] && !flag[i-1]){
                continue;
            }
            flag[i]=true;
            list.add(nums[i]);
            Back_togetChild2(lists,list,size,flag,i+1,nums);
            flag[i]=false;
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int []nums = {1,2,3};
        System.out.println(subsets(nums));
        int []num2={1,2,2};
        System.out.println(subsetsWithDup(num2));
    }
}
