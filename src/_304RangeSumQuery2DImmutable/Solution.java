package _304RangeSumQuery2DImmutable;

class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            sum = new int[1][1];
        } else {
            sum = new int[matrix.length+1][matrix[0].length+1];
            for (int i = 1; i < sum.length; i++) {
                for (int j = 1; j < sum[0].length; j++) {
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
                    sum[i][j] += matrix[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //return sum[row2][col2] - sum[row2][col1-1] - sum[row1-1][col2] + sum[row1-1][col1-1];
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}

public class Solution {

}
