package 笔试;

import java.util.*;

public class ONe0825 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();


    }
    //存在重复数字的情况
    public static int permuteUnique(int[] nums){
        int count=0;
        List<Integer> list=new ArrayList<>();
        boolean []flag=new boolean[nums.length];
        Arrays.sort(nums);
        Back_complete(count,list,flag,nums);
        return count;
    }
    public static void Back_complete(int count,List<Integer> list,boolean []flag,int []nums){
        if(list.size()==nums.length && isPerfect(list)){
            count++;
            return;
        }
        for(int i=0;i<nums.length;i++){
            if (flag[i]){
                continue;
            }
            if (i!=0 && nums[i]==nums[i-1] && !flag[i-1]){
                continue;
            }
            list.add(nums[i]);
            flag[i]=true;
            Back_complete(count,list,flag,nums);
            flag[i]=false;
            list.remove(list.size()-1);
        }
    }
    public static boolean isPerfect(List<Integer> list){
        for (int i=0;i<list.size()-1;i++) {
            if(!isCompSqrt(list.get(i)+list.get(i+1))){
                return false;
            }
        }
        return true;
    }
    public static boolean isCompSqrt(int p){
        boolean flag=false;
        double s=Math.sqrt(p);
        int q=(int) s;
        if(p==Math.pow(q,2)){
            flag=true;
        }
        return flag;
    }






    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int lenA=sc.nextInt();
        int []pushA=new int[lenA];
        for(int i=0;i<lenA;i++){
            pushA[i]=sc.nextInt();
        }
        int lenB=sc.nextInt();
        int []pushB=new int[lenB];
        for(int i=0;i<lenB;i++){
            pushB[i]=sc.nextInt();
        }
        System.out.println(IsPopOrder(pushA,pushB));
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        if(pushA==null||popA==null||pushA.length!=popA.length){
            return false;
        }
        int index=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }*/
}
