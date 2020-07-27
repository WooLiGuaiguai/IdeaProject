package 贪心算法;

import java.util.Arrays;

public class 分发饼干
{
    public static void main(String[] args) {
        int []num1={1,4};
        int []num2={1,2,3};
        System.out.println(findContentChildren(num1,num2));
    }
    public static int findContentChildren(int[] g, int[] s){
        if(g==null||s==null){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i<g.length&&j<s.length){
            if(g[i]<=s[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}
