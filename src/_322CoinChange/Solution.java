package _322CoinChange;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] m = new int[amount+1];
        for (int i = 1; i < m.length; i++) {
            m[i] = Integer.MAX_VALUE;
            int potentialCandid = Arrays.binarySearch(coins, i);
            if (potentialCandid < 0) {
                potentialCandid = -(potentialCandid+1);
            }
            for (int j = potentialCandid; j >= 0; j--) {
                if (i >= coins[j]) {
                    m[i] = Math.min(m[i-coins[j]] + 1, m[i]);
                }
            }
        }
        return m[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{186,419,83,408}, 6249));
    }
}
