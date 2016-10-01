package _48RotateImage;

public class Solution {
    public void rotate1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < (matrix.length+1)/2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = t;
            }
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        for (int i = 0; i < (matrix.length+1)/2; i++) {
            int[] t = matrix[i];
            matrix[i] = matrix[matrix.length-i-1];
            matrix[matrix.length-i-1] = t;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[][]{{1,2},{3,4}});
    }
}
