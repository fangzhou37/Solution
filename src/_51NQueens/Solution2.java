package _51NQueens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        int[] buffer = new int[n];
        dfs(buffer, 0, res);
        return res;
    }

    private void dfs(int[] buffer, int i, List<List<String>> res) {
        if (i == buffer.length) {
            res.add(gen(buffer));
            return;
        }
        for (int j = 0; j < buffer.length; j++) {
            buffer[i] = j;
            if (isValid(buffer, i)) {
                dfs(buffer, i+1, res);
            }
        }
    }

    private boolean isValid(int[] buffer, int i) {
        for (int j = 0; j < i; j++) {
            if (buffer[j] == buffer[i]) {
                return false;
            }
            if (Math.abs(j - i) == Math.abs(buffer[j] - buffer[i])) {
                return false;
            }
        }
        return true;
    }

    private List<String> gen(int[] buffer) {
        List<String> oneSolution = new LinkedList<>();
        char[] row = new char[buffer.length];
        for (int i : buffer) {
            for (int j = 0; j < row.length; j++) {
                if (i == j) {
                    row[j] = 'Q';
                } else {
                    row[j] = '.';
                }
            }
            oneSolution.add(new String(row));
        }
        return oneSolution;
    }
}
