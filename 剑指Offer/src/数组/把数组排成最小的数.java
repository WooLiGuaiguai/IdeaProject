package 数组;

import java.util.Arrays;
import java.util.Comparator;

//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
public class 把数组排成最小的数 {
    public static String PrintMinNumber(int [] numbers){
        if(numbers==null||numbers.length==0){
            return "";
        }
        String []nums=new String[numbers.length];
        //先将数字们转化成字符串
        for (int i=0;i<numbers.length;i++) {
            nums[i]=numbers[i]+"";
        }
        //然后对数组进行排序
        Arrays.sort(nums,(s1,s2)->(s1+s2).compareTo(s2+s1));
        //最后 已经是最小数组了 进行拼接
        StringBuilder sb=new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int []arr={3,32,321};
        System.out.println(PrintMinNumber(arr));
    }
}
