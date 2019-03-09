package discover.datastructure.queueandstack;


/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class PerfectSquares {

    /**
     * 4ms 96.12%
     * 四平方定理
     */
    public int numSquares(int n) {
        // 缩小n
        while (n % 4 == 0) n /= 4;
        // 如果满足公式, 则返回4
        if (n % 8 == 7) return 4;
        // 在判断缩小后的数是否可以由一个数的平方或者两个数平方的和组成
        int a = 0;
        while (a * a <= n) {
            int b = (int) Math.sqrt(n - a * a);
            if (a * a + b * b == n) {
                if (a != 0 && b != 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
            a++;
        }

        // 如果不行 返回3
        return 3;
    }
}
