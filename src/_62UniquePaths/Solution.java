package _62UniquePaths;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] p = new int[n];
        p[n-1] = 1;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (j != n-1) {
                    p[j] += p[j+1];
                }
            }
        }
        return p[0];
    }

    public int uniquePaths1(int m, int n) {
        int[][] p = new int[m][n];
        p[m-1][n-1] = 1;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (j != n-1) {
                    p[i][j] += p[i][j+1];
                }
                if (i != m-1) {
                    p[i][j] += p[i+1][j];
                }
            }
        }
        return p[0][0];
    }
}
