package _329LongestIncreasingPathInAMatrix;

public class Solution {
    // 不需要dfs记忆之前的路径，不需要visited[][],因为path是单调递增的，不会出现“环”
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int path = dfs(matrix, cache, i, j, Integer.MAX_VALUE);
                max = Math.max(max, path);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] cache, int i, int j, int pre) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || pre <= matrix[i][j]) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int length = 0;
        length = Math.max(length, dfs(matrix, cache, i+1, j, matrix[i][j]));
        length = Math.max(length, dfs(matrix, cache, i-1, j, matrix[i][j]));
        length = Math.max(length, dfs(matrix, cache, i, j+1, matrix[i][j]));
        length = Math.max(length, dfs(matrix, cache, i, j-1, matrix[i][j]));
        length++;
        cache[i][j] = length;
        return length;
    }
}
