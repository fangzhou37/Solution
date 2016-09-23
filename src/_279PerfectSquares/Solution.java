package _279PerfectSquares;

public class Solution {
    public int numSquares(int n) {
        int[] m = new int[n+1];
        for (int i = 1; i <= n; i++) {
            m[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                m[i] = Math.min(m[i], m[i-j*j] + 1);
            }
        }
        return m[n];
    }
}
