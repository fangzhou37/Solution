package _64MinimumPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                if (i != 0) {
                    min = Math.min(grid[i-1][j], min);
                }
                if (j != 0) {
                    min = Math.min(grid[i][j-1], min);
                }
                grid[i][j] += min;
            }
        }
        return grid[m-1][n-1];
    }
}
