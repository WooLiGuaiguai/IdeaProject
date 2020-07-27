package 搜索.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个  数字的序列，返回其所有可能的全排列。
public class 全排列 {
    public static void main(String[] args) {
        int [] nums={1,2,3};
        int [] nums2={1,2,1};
        System.out.println(permute(nums));
        System.out.println(permuteUnique(nums));
        System.out.println( );
        System.out.println(permute(nums2));
        System.out.println(permuteUnique(nums2));
    }
    //存在重复数字的情况
    public static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if (nums==null||nums.length==0){
            return lists;
        }
        boolean []flag=new boolean[nums.length];
        Arrays.sort(nums);
        Back_complete2(lists,list,flag,nums);
        return lists;
    }
    public static void Back_complete2(List<List<Integer>> lists,List<Integer> list,boolean []flag,int []nums){
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if (flag[i]){
                continue;
            }
            if (i!=0 && nums[i]==nums[i-1] && !flag[i-1]){
                //和他相同的数字如果正在被访问，那么他可以被进行正常操作
                //如果没有被访问，那么说明前面这个数字已经被访问过，所有组合都已出现，后面这个相同的不必再访问
                //拿1 1 2来说   112 121之后 i=0上的1被标记为false  这时候i=1上的1由于同时满足括号三个条件 它便不能放到集合的第一个位置再次遍历
                continue;
            }
            list.add(nums[i]);
            flag[i]=true;
            Back_complete2(lists,list,flag,nums);
            flag[i]=false;
            list.remove(list.size()-1);
        }
    }
    //没有存在重复数字的情况
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if (nums==null||nums.length==0){
            return lists;
        }
        boolean []flag=new boolean[nums.length];
        Back_complete(lists,list,flag,nums);
        return lists;
    }
    public static void Back_complete(List<List<Integer>> lists,List<Integer> list,boolean []flag,int []nums){
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(flag[i]){
                continue;
            }
            list.add(nums[i]);
            flag[i]=true;
            Back_complete(lists,list,flag,nums);
            flag[i]=false;
            list.remove(list.size()-1);
        }
    }
}
