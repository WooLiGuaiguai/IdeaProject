package 贪心算法;

import java.util.Arrays;

public class GA1 {
    public static void main(String[] args) {
        int []g={11,13,2,3,5,7,9};
        int []s={14,2,3,1,4,5,9};
        System.out.println(findContentChildren(g,s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        if(g==null||s==null){return 0;}
        int glen=0,slen=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(glen<g.length&&slen<s.length){
            if(g[glen]<=s[slen]){
                //胃口小于尺寸
                glen++;
            }
            slen++;
        }
        return glen;
    }
}
