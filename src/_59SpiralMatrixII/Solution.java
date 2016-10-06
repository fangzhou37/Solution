package _59SpiralMatrixII;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int cur = 1;
        int a = 0, b = 0, c = n-1, d = n-1;  // first element: [a, b], last element: [c, d]
        while (a <= c && b <= d) {
            if (a == c) {
                for (int i = b; i <= d; i++) {
                    matrix[a][i] = cur++;
                }
                break;
            }
            if (b == d) {
                for (int i = a; i <= c; i++) {
                    matrix[i][b] = cur++;
                }
                break;
            }
            for (int i = b; i < d; i++) {
                matrix[a][i] = cur++;
            }
            for (int i = a; i < c; i++) {
                matrix[i][d] = cur++;
            }
            for (int i = d; i > b; i--) {
                matrix[c][i] = cur++;
            }
            for (int i = c; i > a; i--) {
                matrix[i][b] = cur++;
            }
            a++;
            b++;
            c--;
            d--;
        }
        return matrix;
    }
}
