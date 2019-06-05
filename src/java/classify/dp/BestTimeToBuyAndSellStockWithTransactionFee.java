package java.classify.dp;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * 5ms 95.75%
     * 50.5MB 95.80%
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;

        int buy = prices[0];
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, prices[i] - buy - fee);
            buy = Math.min(buy, prices[i] - sell);
        }

        return sell;
    }
}
