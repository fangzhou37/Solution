package _74SearchA2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)  return false;

        int height = matrix.length;
        int width = matrix[0].length;

        if(matrix[0][0] > target || matrix[height-1][width-1] < target)	return false;

        int head = 0,tail = height*width-1;
        int mid,midRow,midCol;

        while(head <= tail)
        {
            mid = (head+tail)/2;
            midCol = mid%width;
            midRow = mid/width;
            if(matrix[midRow][midCol] < target)
                head = mid+1;
            else if(matrix[midRow][midCol] > target)
                tail = mid-1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = new int[][] {{1,2,6},{4,5,7},{7,8,9}};
        System.out.println(new Solution().searchMatrix(m, 6));
    }
}
