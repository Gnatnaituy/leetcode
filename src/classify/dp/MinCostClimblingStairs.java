package classify.dp;

public class MinCostClimblingStairs {

    /**
     * 32ms 5.46%
     * 38.5 75.35%
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) return cost[0];

        int[] dp = new int[cost.length];
        dp[1] = Math.min(0, cost[0]) + cost[1];
        dp[2] = Math.min(cost[0], dp[1]) + cost[2];
        for (int i = 3; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }

        return Math.min(dp[dp.length - 2], dp[dp.length - 1]);
    }

    /**
     * 1ms
     */
    public int minCostClimbingStairs2(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
