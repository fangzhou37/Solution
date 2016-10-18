package _221MaximalSquare;

public class Solution2 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] m = new int[matrix.length+1][matrix[0].length+1];
        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    m[i+1][j+1] = Math.min(Math.min(m[i][j], m[i][j+1]), m[i+1][j]) + 1;
                    maxLength = Math.max(maxLength, m[i+1][j+1]);
                }
            }
        }
        return maxLength * maxLength;
    }
}
