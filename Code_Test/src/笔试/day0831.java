package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day0831 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();//测试数据组数
        int []n=new int[T];//每组数据个数
        List<Integer>[] lists=new ArrayList[T];//每组数据

        for(int i=0;i<T;i++){
            n[i]=sc.nextInt();
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<n[i];j++){
                list.add(j,sc.nextInt());
            }
            lists[i]=list;
        }

        for(int i=0;i<lists.length;i++){
            int count=0;
            for(int j=0;j<lists[i].size()-1;j++){
                count=count+lists[i].get(j+1)-lists[i].get(j);
            }
            int num=lists[i].size()-1;
            if(count%num!=0){
                //除不尽不存在
                System.out.println(-1);
            }
            num=count/num;
            int result=0;
            for(int j=0;j<lists[i].size()-1;j++){
                if((lists[i].get(j+1)-lists[i].get(j))!=num){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
