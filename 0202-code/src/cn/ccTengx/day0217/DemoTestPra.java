package cn.ccTengx.day0217;

import java.util.Arrays;

public class DemoTestPra {

    public static void main(String[] args) {

        int []a={1,2,3,4,5};
        System.out.println(Sum_Solution(4));

       /* System.out.println(isContinuous(a));
        String str="i am a student";
        System.out.println(str.trim());
        System.out.println(ReverseSentence("I am a student"));
        System.out.println(ReverseSentence("    I am a student   "));
        System.out.println(ReverseSentence("     "));
        System.out.println(ReverseSentence(null));*/
    }
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
    public static boolean isContinuous(int [] numbers) {
        if(numbers.length<5){//排数小于5张肯定不是顺子
            return false;
        }
        //先排序
        Arrays.sort(numbers);
        //计算癞子数量
        int count=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0) {
                count++;
            }
        }
        //用癞子填补两个数字之间的差值
        for(int i=count;i<numbers.length-1;i++){
            //出现相同的数字肯定不是顺子
            if(numbers[i]==numbers[i+1]){
                return false;
            }
            //3和2之间不差数字   3-2-1
            count=count-(numbers[i+1]-numbers[i]-1);
        }
        if(count>=0){return true;}
        else{return false;}

    }
    public static String ReverseSentence(String str){
        if(str==null)
            return null;
        char []chars=str.toCharArray();
        int len=str.length();
        int i=0,j=0;//两个指针用于标记单词最前边和最后边
        while(j<=len){
            if(j==len||chars[j]==' '){//以每个空格为间隔翻转  但是最后一个没有空格
                reverse(chars,i,j-1);
                i=j+1;//这个单词翻转完毕 j此时是空格 i是下一位
            }
            j++;
        }
        //最后翻转整个句子
        reverse(chars,0,len-1);
        return new String(chars);
    }
    public  static void reverse(char[] c, int i, int j) {
        while (i < j){
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
            i++;j--;
        }
    }

    public static void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
    /*public static String ReverseSentence(String str) {
        //首先判断是否是空串
        if(str==null){return null;}
        //然后判断是不是只由空格组成
        if(str.trim().equals("")){
            return str;
        }
        //将字符串按照空格放进String数组
        String []strs=str.split(" ");
        StringBuffer stringbufffer=new StringBuffer();
        for(int i=strs.length-1;i>=0;i--){
            if(i>0){
                stringbufffer.append(strs[i]+" ");
            }else{
                stringbufffer.append(strs[i]);
            }
        }
        return stringbufffer.toString();
    }*/
}
