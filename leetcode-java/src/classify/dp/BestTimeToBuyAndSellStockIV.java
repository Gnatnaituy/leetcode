package classify.dp;

public class BestTimeToBuyAndSellStockIV {
    
    /**
     * 1ms      99.36%
     * 39.2MB   92.92%
     * T:O(kn)   S:O(k)  DP
     */
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k][2];
        for (int[] d : dp) d[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (j == 0) {
                    dp[0][0] = Math.max(dp[0][0], -prices[i]);
                    dp[0][1] = Math.max(dp[0][1], dp[0][0] + prices[i]);
                } else {
                    dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                    dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
                }
            }
        }

        return dp[k - 1][1];
    }
}
