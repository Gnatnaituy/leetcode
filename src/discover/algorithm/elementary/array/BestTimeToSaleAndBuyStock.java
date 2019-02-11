package discover.algorithm.elementary.array;

public class BestTimeToSaleAndBuyStock {

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