package _375GuessNumberHigherOrLowerII;

public class Solution {
    // dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j]) }
    public int getMoneyAmount(int n) {
        if (n < 2) {
            return 0;
        }
        int[][] m = new int[n+1][n+1];
        for (int length = 2; length <= n; length++) {    // if length == 1, it's the right answer, no need to pay
            for (int i = 1; i + length - 1 <= n; i++) {
                int j = i + length - 1;
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int firstPartCost = 0;
                    if (k - 1 >= 0) {
                        firstPartCost = m[i][k-1];
                    }
                    int secondPartCost = 0;
                    if (k + 1 <= j) {
                        secondPartCost = m[k+1][j];
                    }
                    int worstCaseCost = Math.max(firstPartCost, secondPartCost) + k;
                    minCost = Math.min(minCost, worstCaseCost);
                }
                m[i][j] = minCost;
            }
        }
        return m[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(10));
    }
}
