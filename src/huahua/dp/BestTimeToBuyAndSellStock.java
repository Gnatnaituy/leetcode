package huahua.dp;


public class BestTimeToBuyAndSellStock {

    /**
     * 1ms 81.01%
     * 39.5MB 41.7%
     */
    public int maxProfit(int[] prices) {
        int cur = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            cur += prices[i] - prices[i - 1];
            cur = Math.max(cur, prices[i] - prices[i - 1]);
            max = Math.max(max, cur);
        }

        return max;
    }
}
