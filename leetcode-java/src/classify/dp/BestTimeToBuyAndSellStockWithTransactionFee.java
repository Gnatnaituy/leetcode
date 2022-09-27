package classify.dp;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * 18ms     51.81%
     * 48.9MB   72.66%
     * T:O(n)   S:O(n)  DP
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[dp.length - 1][0];
    }

    /**
     * 4ms      88.31%
     * 49.6MB   30.45%
     * T:O(n)   S:O(1)  DP  
     * 优化空间复杂度
     */
    public int maxProfit2(int[] prices, int fee) {
        int buy = -prices[0], sell = 0;

        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }

        return sell;
    }
}
