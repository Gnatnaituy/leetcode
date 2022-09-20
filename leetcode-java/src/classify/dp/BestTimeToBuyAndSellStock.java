package classify.dp;


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

    /**
     * 3ms      60.09%
     * 51.4MB   57.07%
     * T:O(n) S:O(1) 动态规划
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    /**
     * 1ms      100.00%
     * 57.4MB   67.56%
     * T:O(n) S:O(1) 贪心算法
     */
    public int maxProfit3(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
                continue;
            }
            if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
