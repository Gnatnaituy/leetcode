package classify.dp;

/**
 * @author yutiantang
 * @create 2021/10/27 18:28
 * 746. 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

    /**
     * 1ms      92.81%
     * 37.9MB   88.15%
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 2) return 0;

        int pprev = 0, prev = cost[0];
        for (int i = 1; i < cost.length; i++) {
            int temp = prev;
            prev = cost[i] + Math.min(prev, pprev);
            pprev = temp;
        }

        return Math.min(pprev, prev);
    }
}
