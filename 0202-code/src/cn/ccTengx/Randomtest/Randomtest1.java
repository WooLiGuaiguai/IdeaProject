package cn.ccTengx.Randomtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Randomtest1 {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        Random random=new Random( );
        Scanner sc=new Scanner(System.in);
        int i = random.nextInt();//在不超过int的范围内随机取数
        int j = random.nextInt(100);//在[0,99]之间取数
        int k = random.nextInt(10)+1;//在[1,10]之间取数
        System.out.println("随机数是："+j);
        System.out.println("现在开始一个猜字游戏，你有10次机会");
        for(int m=0;m<10;m++){
            System.out.println("输入你猜测的数字：");
            int num=sc.nextInt();
            if(num==j){
                System.out.println("congratulation");
                break;
            }else if(num>j){
                System.out.println("too big");
            }else{
                System.out.println("too smmall");
            }
        }
        System.out.println("game over");
    }
}
