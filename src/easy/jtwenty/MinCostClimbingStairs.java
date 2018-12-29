package easy.jtwenty;

/**
 * 746 Min Cost Climbing Stairs
 */

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        switch (cost.length) {
            case 0:
                return 0;
            case 1:
                return cost[0];
            case 2:
                return Math.min(cost[0], cost[1]);
            default:
                for (int i = 2; i < cost.length; i++)
                    cost[i] = Math.min(cost[i - 1] + cost[i], cost[i - 2] + cost[i]);
                return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        }
    }
}