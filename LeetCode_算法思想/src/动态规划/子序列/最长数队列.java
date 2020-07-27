package 动态规划.子序列;
//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
//现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
//给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。

import java.util.Arrays;
import java.util.Comparator;

//输入: [[1,2], [2,3], [3,4]]
//输出: 2
public class 最长数队列 {
    public static void main(String[] args) {
        int [][]a={{1,2}, {2,3}, {3,4}};
        System.out.println(findLongestChain(a));
    }
    public static int findLongestChain(int[][] pairs){
        if(pairs==null ||pairs.length==0){
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int []dp=new int[pairs.length];
        for (int i=0;i<pairs.length;i++){
            int maxlen=1;
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    maxlen=Math.max(maxlen,dp[j]+1);
                }
            }
            dp[i]=maxlen;
        }
        int ret=0;
        for (int i : dp) {
            ret=Math.max(ret,i);
        }
        return ret;
    }
}
