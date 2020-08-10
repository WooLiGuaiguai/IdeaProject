package 数组;

import java.util.ArrayList;
import java.util.Arrays;
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
public class 和为S的两个数字 {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum){
        int start=0,end=array.length-1;
        while(start<end){
            if(array[start]+array[end]==sum){
                return new ArrayList<>(Arrays.asList(array[start],array[end]));
            }else if(array[start]+array[end]<sum){
                start++;
            }else{
                end--;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int []array=new int[5];
        System.out.println(FindNumbersWithSum(array,12));
    }
}
