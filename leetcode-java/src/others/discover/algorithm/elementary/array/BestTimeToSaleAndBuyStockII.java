package others.discover.algorithm.elementary.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class BestTimeToSaleAndBuyStockII {

    /**
     * 1ms 100%
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }

        return maxprofit;
    }
}

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润 注意你不能在买入股票前卖出股票
 */
class BestTimeToSaleAndBuyStock {

    /**
     * 775ms 2.55%
     */
    public int maxProfit(int[] prices) {
        int best = 0;
        for (int i = 0; i < prices.length; i++) {
            int nowBest = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > nowBest)
                    nowBest = prices[j] - prices[i];
            }
            best = nowBest > best ? nowBest : best;
        }
        return best;
    }

    /**
     * 1ms 100%
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(price - min, max);
            }
        }

        return max;
    }

    /**
     * 3ms
     */
    public int maxProfit3(int[] prices) {
        if (prices.length == 0)
            return 0;
        int max = 0;
        int oldPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (oldPrice > prices[i]) {
                oldPrice = prices[i];
            }
            max = Math.max(max, prices[i] - oldPrice);
        }

        return max;
    }
}