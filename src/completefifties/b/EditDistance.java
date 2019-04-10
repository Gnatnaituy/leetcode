package completefifties.b;


/**
 * 72 编辑距离
 * <p>
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1:
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * <p>
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
public class EditDistance {

    /**
     * 25ms 5.35%
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= word1.length(); i++)
            dp[i][0] = dp[i - 1][0] + 1;
        for (int j = 1; j <= word2.length(); j++)
            dp[0][j] = dp[0][j - 1] + 1;

        for (int i = 1; i <= word1.length(); i++)
            for (int j = 1; j <= word2.length(); j++)
                dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1),
                        word1.charAt(i - 1) == word2.charAt(j - 1) ?
                                dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1);

        return dp[word1.length()][word2.length()];
    }

    /**
     * 4ms
     * 定义一个表达式D(i,j)
     * 它表示从第1个字单词的第0位至第i位形成的子串和第2个单词的第0位至第j位形成的子串的编辑距离
     * 显然，可以计算出动态规划的初始表达式，如下:
     * D(i,0) = i
     * D(0,j) = j
     * 然后，考虑动态规划的状态转移方程式，如下:
     * D(i, j) = min(D(i-1, j) + 1, D(i, j-1) + 1, X(i) == Y(j) ? D(i-1, j-1) : D(i-1, j-1) + 1)
     * <p>
     * 上面的状态转移方程的含义是，D(i,j)的值，要么是D(i-1, j)的操作完成之后删除一个字符(第1个单词的第i个字符)，
     * 要么是D(i, j-1)的操作完成之后增加一个字符(第2个单词的第j个字符)，
     * 要么是D(i-1, j-1)的操作完成自后替换一个字符(如果第1个单词的第i个字符和第2个单词的第j个字符不等)，
     * 或者是D(i-1, j-1)的操作完成自后什么也不做(如果第1个单词的第i个字符和第2个单词的第j个字符相等)。
     */
    public int minDistance2(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        return edit(word1.length(), word2.length(), word1, word2, dp);
    }

    private int edit(int l, int r, String w1, String w2, int[][] dp) {
        if (l == 0) return r;
        if (r == 0) return l;
        if (dp[l][r] != 0) return dp[l][r];
        int min;
        if (w1.charAt(l - 1) != w2.charAt(r - 1)) {
            min = Math.min(edit(l - 1, r, w1, w2, dp) + 1, edit(l, r - 1, w1, w2, dp) + 1);
            min = Math.min(edit(l - 1, r - 1, w1, w2, dp) + 1, min);
        } else {
            min = edit(l - 1, r - 1, w1, w2, dp);
        }
        dp[l][r] = min;
        return min;
    }
}
