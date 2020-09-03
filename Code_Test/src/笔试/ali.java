package 笔试;

import java.util.Scanner;

public class ali {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int []result=select(A,B,a,b);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
    public static int[] select(int A,int B,int a,int b){
        int []result=new int[2];
        float value=(float)(a/b);
        if(value>A){
            result[0]=0;
            result[1]=0;
            return result;
        }
        for(int i=0;i<=B;i++){
            if((long)i*value==(i*value) && i*value<=A){
                result[0]=(int)(i*value);
                result[1]=i;
            }
        }
        return result;
    }
    /*
    * package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int []n=new int[T];//结点个数
        int []m=new int[T];//双向路径个数
        for(int i=0;i<T;i++){
            //第i组数组的结点和路径个数
            n[i]=sc.nextInt();
            m[i]=sc.nextInt();
            //边的两个结点 以及路径长度
            int []a=new int[m[i]];
            int []b=new int[m[i]];
            int []c=new int[m[i]];
            for(int j=0;j<m[i];j++){
                a[j]=sc.nextInt();
                b[j]=sc.nextInt();
                c[j]=sc.nextInt();
            }
            //询问次数
            int Q=sc.nextInt();
            int []f=new int[Q];
            for(int k=0;k<Q;k++){
                f[k]=sc.nextInt();
            }
        }

        for(int i=0;i<T;i++){
            int num=n[i];//获取第i组结点的个数
            int [][]matrix=new int[num][num];//双向
            Arrays.fill(matrix,-1);
            for(int j=0;j<num;j++){
                for(int k=0;k<num;k++){

                }
            }
        }
    }
}
*/
}