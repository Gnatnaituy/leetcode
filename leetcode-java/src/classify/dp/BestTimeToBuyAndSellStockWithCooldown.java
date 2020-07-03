package classify.dp;

public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * 1ms 94.29%
     * 37MB 93.64%
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int buy = -prices[0], sell = 0;
        int prevSell = 0;
        int newBuy, newSell;

        for (int i = 1; i < prices.length; i++) {
            newBuy = Math.max(prevSell - prices[i], buy);
            newSell = Math.max(buy + prices[i], sell);
            prevSell = sell;
            buy = newBuy;
            sell = newSell;
        }

        return sell;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[prices.length - 1];
    }
}
