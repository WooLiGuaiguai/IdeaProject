package 动态规划.字符串编辑;
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//你可以对一个单词进行如下三种操作：
//插入一个字符
//删除一个字符
//替换一个字符

//abc->ab 只需要将abc的c删除可以变为ab 编辑距离为1;
//ab->abc 只需要在ab的末尾加上c可以变为abc 编辑距离为1；
//abd->abc 只需要将d字符串替换为c可以变为abc 编辑距离为1；
//
//所有的操作仅仅有以上三种基本操作。
//那么定义一个字符串"monkey"最少经过多少次可以变为变为"online"?
//假设有两个字符串 s t ，其中s的长度为 m ,t的长度为n 。
//d[i][j]表示字符串s[i-1]到字符串m[j-1]的编辑距离。
//当 s[i] 等于 t[j] 时，d[i][j] = d[i-1][j-1], 比如 abc -> adc 的编辑距离等于 ab -> ad 的编辑距离
//当 s[i] 不等于 t[j] 时，d[i][j] 等于如下 3 项的最小值：
//d[i-1][j] + 1（删除 s[i]）， 比如 adf -> abc 的编辑距离 = ad -> abc 的编辑距离 + 1
//d[i][j-1] + 1（插入 t[j])， 比如 adf -> abc 的编辑距离 = adfc -> abc 的编辑距离 + 1 = adf -> ab 的编辑距离 + 1
//d[i-1][j-1] + 1（将 s[i] 替换为 t[j]）， 比如 xyz -> abc 的编辑距离 = xyc -> abc 的编辑距离 + 1 = xy -> ab 的编辑距离 + 1
public class 增删改 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }

}
