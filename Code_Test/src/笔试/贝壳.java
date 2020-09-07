package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 贝壳 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();//数据组数
        int []n=new int[T];//每组数据栅栏总数
        int []m=new int[T];//每组数据颜料总数
        int []k=new int[T];//每组数据 不能紧跟颜料数目
        List<List<Integer>> []lists=new ArrayList[T];
        for(int i=0;i<T;i++){
            n[i]=sc.nextInt();
            m[i]=sc.nextInt();
            k[i]=sc.nextInt();
            for(int j=0;j<m[i];j++){//这组数据一共有m[i]个集合 每个集合存放该颜料不能紧跟颜料
                List<Integer> list=new ArrayList<>();
                for(int l=0;l<k[i];l++){
                    int c=sc.nextInt();
                    list.add(c);
                }
                lists[i].add(list);
            }
        }
        for (List<List<Integer>> list : lists) {
            System.out.println(list);
        }
    }
}
