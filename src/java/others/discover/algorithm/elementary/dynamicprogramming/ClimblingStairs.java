package java.others.discover.algorithm.elementary.dynamicprogramming;


/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimblingStairs {

    /**
     * 递归法
     * 不可行 当n增加到43时便超出了时间限制
     */
    public int climbStairs(int n) {
        if (n < 2) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 3ms 82.31%
     */
    public int climbStairs2(int n) {
        int pre = 0;
        int aft = 1;
        int tmp;

        for (int i = 1; i < n; i++) {
            tmp = pre;
            pre = aft;
            aft = tmp + aft;
        }

        return pre + aft;
    }

    /**
     * 4ms 37.12%
     * 19.5m 98.00%
     */
    public int climbStairs3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] cache = new int[n];

        cache[0] = 1;
        cache[1] = 2;
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[n-1];
    }
}

