package _63UniquePathsII;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] path = new int[m][n];   // the path count starting from i, j to end point
        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        path[m-1][n-1] = 1;
        for (int row = m-1; row >= 0; row--) {
            for (int col = n-1; col >= 0; col--) {
                if (obstacleGrid[row][col] == 1) {
                    continue;
                }
                if (row+1 < m) {
                    path[row][col] += path[row+1][col];
                }
                if (col+1 < n) {
                    path[row][col] += path[row][col+1];
                }
            }
        }
        return path[0][0];
    }
}
