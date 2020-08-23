package 笔试;

import java.util.Scanner;

public class 用户名合理性与数组重排列 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int []nm=new int[2];
        for(int i=0;i<2;i++){
            nm[i]=sc.nextInt();//获取n 数列是1-n
                               //获取m  操作执行次数
        }
        int n=nm[0],m=nm[1];
        int []arr=new int[n];
        for(int i=0;i<n;i++){//获取这个被操作数组
            arr[i]=i+1;
        }
        int [] does=new int[m];//操作执行数组
        for(int i=0;i<m;i++){
            does[i]=sc.nextInt();//获取数组操作数
        }

        //执行操作
        for(int i=0;i<m;i++){
            if(does[i]==1){//执行第一种操作
                for(int j=1;j<n;j++){
                    swap(arr,j,j-1);
                }
            }else if(does[i]==2){//执行第二种操作
                for(int j=1;j<n;j=j+2){
                    swap(arr,j,j-1);
                }
            }else{
                System.out.println("输入m错误");
            }
        }
        //输出结果
        for (int i : arr) {
            System.out.print(i+" ");
        }

    }
    public static void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }






    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String []strings=new String[n];
        for(int i=0;i<n;i++){
            strings[i]=sc.next();
        }
        int count=0;//统计总个数
        for(int i=0;i<strings.length;i++){//遍历字符串数组
            char[]chars=strings[i].toCharArray();//获取一个字符串
            if(chars.length>10){
                continue;
            }
            int len=0;//判断数字和字母个数
            for (char aChar : chars) {//遍历每个字符
                if((aChar>='A' && aChar<='Z')||(aChar>='a' && aChar<='z') ){
                    len++;
                }
            }
            if(len==chars.length){
                count++;
            }
        }
        System.out.println(count);
    }*/
}
