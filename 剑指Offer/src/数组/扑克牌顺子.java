package 数组;

import java.util.Arrays;

//54张牌  大小王做癞子
public class 扑克牌顺子 {
    public static boolean isContinuous(int [] numbers){
        if(numbers.length<5){
            return false;
        }
        int countZero=0;//统计癞子个数
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
                countZero++;
            }
        }
        for(int i=countZero;i<numbers.length-1;i++){
            if(numbers[i]==numbers[i+1]){
                return false;//除0之外不能够相同
            }
            //填补癞子
            countZero=countZero-(numbers[i+1]-numbers[i]-1);//2和3之间不需要癞子
        }
        return countZero>=0;
    }

    public static void main(String[] args) {
        int []numbers={0,0,0,1,2,3,9,8,0};
        System.out.println(isContinuous(numbers));
    }
}
