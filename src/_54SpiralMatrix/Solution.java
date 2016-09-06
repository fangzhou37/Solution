package _54SpiralMatrix;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int a = 0, b = 0, c = matrix.length-1, d = matrix[0].length-1;  // first element: [a, b], last element: [c, d]
        while (a <= c && b <= d) {
            if (a == c) {
                for (int i = b; i <= d; i++) {
                    res.add(matrix[a][i]);
                }
                break;
            }
            if (b == d) {
                for (int i = a; i <= c; i++) {
                    res.add(matrix[i][b]);
                }
                break;
            }
            for (int i = b; i < d; i++) {
                res.add(matrix[a][i]);
            }
            for (int i = a; i < c; i++) {
                res.add(matrix[i][d]);
            }
            for (int i = d; i > b; i--) {
                res.add(matrix[c][i]);
            }
            for (int i = c; i > a; i--) {
                res.add(matrix[i][b]);
            }
            a++;
            b++;
            c--;
            d--;
        }
        return res;
    }
}
