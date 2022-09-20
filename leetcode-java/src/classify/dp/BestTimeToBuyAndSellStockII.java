package classify.dp;

public class BestTimeToBuyAndSellStockII {
    
    /**
     * 1ms      81.77%
     * 41.4MB   50.84%
     * T:O(n)   S:O(n)  DP
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        }

        return dp[dp.length - 1];
    }

    /**
     * 1ms      81.77%
     * 41MB     95.01%
     * T:O(n)   S:O(1)  DP
     * 优化空间复杂度
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxProfit + prices[i] - prices[i - 1]);
        }

        return maxProfit;
    }
}
