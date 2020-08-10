package 数组;
//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
//num1,num2分别为长度为1的数组。将num1[0],num2[0]设置为返回结果
public class 只出现一次的两个数字 {
 /* 两个不相等的元素在位级表示上必定会有一位存在不同，
    将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果
    diff &= -diff -diff是diff取反加一
    得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，*/
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff_two=0;
        for(int num:array){
            diff_two=diff_two^num;//最终得到的diff_two是两个不同的数异或的结果
        }
        //找到两个数二进制表示的右侧不同的第一位
        diff_two=diff_two&(-diff_two);
        for(int num:array){
            if((num&diff_two)==0){
                num1[0]=num1[0]^num;
            }else{
                num2[0]=num2[0]^num;
            }
            //不用考虑其他的数字会有影响 即使==0，相同的两个数字也会在后面的异或中变成0
        }
    }
}
