package _322CoinChange;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] minChange = new int[amount+1];
        for (int curAmount = 1; curAmount < minChange.length; curAmount++) {
            minChange[curAmount] = Integer.MAX_VALUE;
            int potentialCoinIndex = Arrays.binarySearch(coins, curAmount);
            if (potentialCoinIndex < 0) {
                potentialCoinIndex = -(potentialCoinIndex+1);
            }
            if (potentialCoinIndex >= coins.length) {
                potentialCoinIndex--;
            }
            for (int j = potentialCoinIndex; j >= 0; j--) {
                if (curAmount >= coins[j] && minChange[curAmount-coins[j]] != Integer.MAX_VALUE) {
                    minChange[curAmount] = Math.min(minChange[curAmount-coins[j]] + 1, minChange[curAmount]);
                }
            }
        }
        return minChange[amount] == Integer.MAX_VALUE ? -1 : minChange[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{186,419,83,408}, 6249));
    }
}
