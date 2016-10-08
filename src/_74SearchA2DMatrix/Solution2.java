package _74SearchA2DMatrix;

public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = m * n - 1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            int x = mid/n;
            int y = mid%n;
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}
