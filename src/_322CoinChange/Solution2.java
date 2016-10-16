package _322CoinChange;

import java.util.Arrays;

public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] minChange = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            minChange[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    break;
                }
                if (minChange[i - coins[j]] != Integer.MAX_VALUE) {
                    minChange[i] = Math.min(minChange[i], minChange[i - coins[j]] + 1);
                }
            }
        }
        return minChange[amount] == Integer.MAX_VALUE ? -1 : minChange[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().coinChange(new int[]{186,419,83,408}, 6249));
    }
}
