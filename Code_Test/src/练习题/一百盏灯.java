package 练习题;

import java.util.Arrays;

public class 一百盏灯 {
    public static void main(String[] args) {
        int []nums=new int[101];
        Arrays.fill(nums,0);
        System.out.println(Count(nums));
    }
    public static int Count(int []nums){
        int count=0;
        int []pao=new int[101];//编号从1-100
        Arrays.fill(pao,0);//0表示关闭  1表示开启
        for(int i=1;i<=100;i++){//100个人
            for(int j=1;j<=100;j++) {//100个灯泡
                if(j%i==0){
                    if(pao[j]==0){
                        pao[j]=1;
                    }else {
                        pao[j]=0;
                    }
                }
            }
        }
        for (int i : pao) {
            if(i==1){
                count++;
            }
        }
        return count;
    }
}
