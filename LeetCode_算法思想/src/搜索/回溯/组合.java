package 搜索.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合 {
    //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if(k>n){
            return lists;
        }
        Back_Combine(lists,list,1,n,k);
        return lists;
    }
    public static void Back_Combine(List<List<Integer>> lists,List<Integer> list,int start,int n,int k){
        if(list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<=n;i++){//i指针不断向后移动可以保证[1,2]和[2,1]不会同时出现
            list.add(i);
            Back_Combine(lists,list,i+1,n,k);
            list.remove(list.size()-1);
        }
    }
    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //candidates 中的数字可以无限制重复被选取。
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Back_Combine2(lists,list,candidates,0,target);
        return lists;
    }
    public static void Back_Combine2(List<List<Integer>> lists,List<Integer> list,int[] candidates,int start,int target){
        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if(candidates[i]<=target){
                list.add(candidates[i]);
                Back_Combine2(lists,list,candidates,i,target-candidates[i]);//start的值选择i意味着后面可以重复选取
                list.remove(list.size()-1);
            }
        }
    }
    //含有相同元素的数组 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //candidates 中的每个数字在每个组合中只能使用一次。
    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean []flag=new boolean[candidates.length];
        Arrays.sort(candidates);//关键的一步是这个排序
        Back_Combine3(lists,list,candidates,flag,0,target);
        return lists;
    }
    public static void Back_Combine3(List<List<Integer>> lists,List<Integer> list,int[] candidates,boolean []flag,int start,int target){
        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(flag[i]){
                continue;
            }
            if(i!=0 && candidates[i]==candidates[i-1] && !flag[i-1]){
                continue;
            }
            if(candidates[i]<=target){
                flag[i]=true;
                list.add(candidates[i]);
                Back_Combine3(lists,list,candidates,flag,i+1,target-candidates[i]);
                list.remove(list.size()-1);
                flag[i]=false;
            }
        }
    }
    //找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
    public static List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Back_Combine4(lists,list,n,k,1);
        return lists;
    }
    public static void Back_Combine4(List<List<Integer>> lists,List<Integer> list,int target,int k,int start){
        if(target==0 && k==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(target==0||k==0){
            return;
        }
        for(int i=start;i<=9;i++){
            list.add(i);
            Back_Combine4(lists,list,target-i,k-1,i+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int []candidates={2,3,6,7,9};
        System.out.println(combine(4,2));
        System.out.println(combinationSum(candidates,9));
        int [] candidates2 = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates2,8));
        System.out.println(combinationSum3(3,9));
    }
}
