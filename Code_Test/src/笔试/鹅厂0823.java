package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 鹅厂0823 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int Q=sc.nextInt();
        int [][]num=new int[Q][2];
        for(int i=0;i<Q;i++){
            num[i][0]=sc.nextInt();//l
            num[i][1]=sc.nextInt();
        }

        for (int[] nums : num) {
            int l=nums[0];
            int r=nums[1];
            String string=str.substring(l-1,r);
            List<List<String>> lists=partition(string);
            int minlen=Integer.MAX_VALUE;
            for (List<String> list : lists) {
                minlen=Math.min(minlen,list.size());
            }
            System.out.println(minlen);
        }
    }
    public static List<List<String>> partition(String s){
        List<List<String>> lists=new ArrayList<>();
        List<String> list=new ArrayList<>();
        doCut(lists,list,s);
        return lists;
    }
    public static void doCut(List<List<String>> lists,List<String> list,String s){
        if(s.length()==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        char []chars=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(isPalindrome(chars,0,i)){
                list.add(s.substring(0,i+1));
                doCut(lists,list,s.substring(i+1));
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isPalindrome(char []chars,int start,int end){
        while(start<end){
            if(chars[start]!=chars[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;//如果start==end 表示同一个字母 直接返回true
    }
    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();//获取组数
        int []num=new int[T];//获取数据
        for (int i=0;i<T;i++){
            num[i]=sc.nextInt();
        }
        for(int i=0;i<T;i++){
            if(num[i]<=1){
                System.out.println(1);
                continue;
            }
            int left=1,right=num[i]-1;
            int max=Integer.MIN_VALUE;
            while(left<right){
                max=Math.max(max,Compute(left)+Compute(right));
                left++;
                right--;
            }
            System.out.println(max);
        }
    }
    public static int Compute(int number){
        int a=0;
        int count=0;
        while(number!=0){
            a=number%10;
            count=count+a;
            number=number/10;
            a=number;
        }
        return count;
    }*/
}
