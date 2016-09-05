package _309BestTimeToBuyAndSellStockWithCooldown;

public class Solution {
    /*
                1	2	3	0	2
        Sell	0	1	2	2	3
        Buy	    -1	-1	-3	1	1

        Sell[2] = max(Buy[1] + prices[2], Sell[1]) = max(1, 0) = 1
        Buy[2] = max(Sell[0] - prices[2], Buy[1]) = max(-2, -1) = -1

        Sell[3] = max(Buy[2] + prices[3], Sell[2]) = max(2, 1) = 2
        Buy[3] = max(Sell[1] - prices[3], Buy[2]) = max(-3, 2) = 2
    */
    public int maxProfit(int[] prices) {
        // buy[i] = max(sell[i-2]-price, buy[i-1])
        // sell[i] = max(buy[i-1]+price, sell[i-1])
        if (prices.length < 2) {
            return 0;
        }
        int sell_2 = 0, sell_1 = 0, sell = 0;
        int buy_1 = -prices[0], buy = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(sell_2 - prices[i], buy_1);
            sell = Math.max(buy_1 + prices[i], sell_1);
            sell_2 = sell_1;
            sell_1 = sell;
            buy_1 = buy;
        }
        return Math.max(buy, sell);
    }
}
