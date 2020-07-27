package 动态规划.背包问题;
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//拆分时可以重复使用字典中的单词。
//你可以假设字典中没有重复的单词。

import java.util.List;

//这是一个完全背包问题，同时要注意必须按照单词的顺序排列
//求解顺序的完全背包问题时，对物品的迭代应该放在最里层，对背包的迭代放在外层，只有这样才能让物品按一定顺序放入背包中。
public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict){
        int n=s.length();
        boolean []dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for (String s1 : wordDict) {
                int len=s1.length();
                if(len<=i && s1.equals(s.substring(i-len,i))){
                    dp[i]=dp[i]||dp[i-len];
                }
            }
        }
        return dp[n];
    }
}
