package _123BestTimeToBuyAndSellStockIII;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] low = new int[prices.length]; // profit from 0 to i
        int left = prices[0];
        for (int i = 1; i < prices.length; i++) {
            low[i] = Math.max(low[i-1], prices[i] - left);
            left = prices[i] < left ? prices[i] : left;
        }

        int[] high = new int[prices.length]; // profit from i to end
        int right = prices[prices.length-1];
        for (int i = prices.length-2; i >= 0; i--) {
            high[i] = Math.max(high[i+1], right - prices[i]);
            right = prices[i] > right ? prices[i] : right;
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, low[i] + high[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {2,1,2,0,1}));
    }

}
