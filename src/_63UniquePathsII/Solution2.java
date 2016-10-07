package _63UniquePathsII;

public class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] p = new int[n];
        p[n-1] = 1;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (j != n-1) {
                    p[j] += p[j+1];
                }
                if (obstacleGrid[i][j] == 1) {
                    p[j] = 0;
                }
            }
        }
        return p[0];
    }
}
