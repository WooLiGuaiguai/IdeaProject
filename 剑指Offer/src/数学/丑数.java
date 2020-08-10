package 数学;

import java.util.ArrayList;

public class 丑数 {
    public static int GetUglyNumber_Solution(int index,ArrayList<Integer> list){
        if(index<=6){
            return index;
        }
        int []dp=new int[index];
        dp[0]=1;
        //+++++++list.add(dp[0]);
        int i2=0,i3=0,i5=0;//三个指针进行标记
        for(int i=1;i<index;i++){
            int next2i=2*dp[i2],next3i=3*dp[i3],next5i=5*dp[i5];////nexti保存的是乘以i过后目前最大的值，进行比较，取最小值加入数组
            dp[i]=Math.min(next2i,Math.min(next3i,next5i));
            //判断是通过乘几的到的 相应的指针向前移动，没有移动的nexti保留的仍旧是之前的值
            if(dp[i]==next2i){
                i2++;
            }
            if(dp[i]==next3i){
                i3++;
            }
            if(dp[i]==next5i){
                i5++;
            }
            //list.add(dp[i]);
        }
        return dp[index-1];
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println(GetUglyNumber_Solution(10,list));
        System.out.println(list);
    }
}
/*首先从丑数的定义我们知道，一个丑数的因子只有2,3,5，那么丑数p = 2 ^ x * 3 ^ y * 5 ^ z，换句话说一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，那么我们从1开始乘以2,3,5，就得到2,3,5三个丑数，在从这三个丑数出发乘以2,3,5就得到4，6,10,6，9,15,10,15,25九个丑数，我们发现这种方***得到重复的丑数，而且我们题目要求第N个丑数，这样的方法得到的丑数也是无序的。那么我们可以维护三个队列：
（1）丑数数组： 1
乘以2的队列：2
乘以3的队列：3
乘以5的队列：5
选择三个队列头最小的数2加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
（2）丑数数组：1,2
乘以2的队列：4
乘以3的队列：3，6
乘以5的队列：5，10
选择三个队列头最小的数3加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
（3）丑数数组：1,2,3
乘以2的队列：4,6
乘以3的队列：6,9
乘以5的队列：5,10,15
选择三个队列头里最小的数4加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
简化一些，这个队列可以不使用三个来实现，而是使用三个指针进行标记*/