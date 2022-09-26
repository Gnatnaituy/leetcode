package classify.dp;

public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * 0ms      100.00%
     * 39.2MB   97.90%
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[prices.length - 1];
    }
}
