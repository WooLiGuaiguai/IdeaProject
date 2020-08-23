package 笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 搬运货物 {
   /* public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int []index=new int[num];
        int []weight=new int[num];
        for(int i=0;i<num;i++){
            weight[i]=sc.nextInt();
        }
        for(int i=0;i<num;i++){
            index[i]=sc.nextInt();
        }
        for(int i=0;i<num;i++){
            weight[index[i]-1]=0;
            int left_w=0;
            int right_w=0;
            if(index[i]-1==0){
                for(int j=1;j<num;j++){
                    right_w=right_w+weight[j];
                }
                System.out.println(right_w);
            }else if(index[i]-1==num-1){
                for(int j=0;j<num-1;j++){
                    left_w=left_w+weight[j];
                }
                System.out.println(left_w);
            }else{
                for(int l=0;l<=index[i]-1-1;l++){
                    left_w=left_w+weight[l];
                }
                for(int r=index[i]-1+1;r<num;r++){
                    right_w=right_w+weight[r];
                }
                int max=Math.max(left_w,right_w);
                System.out.println(max);
            }
        }
    }*/
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int []index=new int[num];
        int []weight=new int[num];
        for(int i=0;i<num;i++){
            weight[i]=sc.nextInt();
        }
        for(int i=0;i<num;i++){
            index[i]=sc.nextInt();
        }
        for(int i=0;i<num;i++){
            weight[index[i]-1]=0;
            int left_w=0;
            int right_w=0;
            if(index[i]-1==0){
                for(int j=1;j<num;j++){
                    right_w=right_w+weight[j];
                }
                System.out.println(right_w);
            }else if(index[i]-1==num-1){
                for(int j=0;j<num-1;j++){
                    left_w=left_w+weight[j];
                }
                System.out.println(left_w);
            }else{
                for(int l=0;l<=index[i]-1-1;l++){
                    left_w=left_w+weight[l];
                }
                for(int r=index[i]-1+1;r<num;r++){
                    right_w=right_w+weight[r];
                }
                int max=Math.max(left_w,right_w);
                System.out.println(max);
            }
        }
    }

}
