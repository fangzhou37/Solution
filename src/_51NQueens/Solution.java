package _51NQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] b = new int[n];   // b[i] means in row i, where shall we put the queen
        solve(res, b, 0);
        return res;
    }

    private void solve(List<List<String>> res, int[] b, int row) {
        if (row == b.length) {
            res.add(genResult(b));
            return;
        }
        for (int j = 0; j < b.length; j++) {
            boolean canPut = true;
            for (int i = 0; i < row; i++) {
                if (b[i] == j) {
                    canPut = false;
                    break;
                }
                if (Math.abs(b[i] - j) == Math.abs(i - row)) {
                    canPut = false;
                    break;
                }
            }
            if (canPut) {
                b[row] = j;
                solve(res, b, row+1);
            }
        }
    }

    private List<String> genResult(int[] b) {
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < b.length; j++) {
                if (b[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            arr.add(sb.toString());
        }
        return arr;
    }
}
