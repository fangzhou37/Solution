package _221MaximalSquare;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] m = new int[matrix.length+1][matrix[0].length+1];
        int maxLength = 0;
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (matrix[i-1][j-1] == '1') {
                    m[i][j] = Math.min(m[i-1][j], Math.min(m[i][j-1], m[i-1][j-1])) + 1;
                    maxLength = Math.max(maxLength, m[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(new char[][] {{'1'}}));
    }
}
