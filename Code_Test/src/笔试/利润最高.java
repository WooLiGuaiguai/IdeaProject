package 笔试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 利润最高 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]bucket=new int[n][2];
        for(int i=0;i<n;i++){
            bucket[i][0]=sc.nextInt();
            bucket[i][1]=sc.nextInt();
        }
        int []money=new int [n];
        for(int i=0;i<n;i++){
            money[i]=bucket[i][0]+bucket[i][1]*2;
        }
        List<Integer> list=new ArrayList<>();
        while (m > 0) {

            int max=0;
            int index=-1;
            for(int i=0;i<n;i++){
                if(money[i]>max){
                    max=money[i];
                    index=i+1;
                }
            }
            list.add(index);
            money[index-1]=0;
            m--;
        }
        Collections.sort(list);
        for(int i:list){
            System.out.print(i+" ");
        }
    }
}
