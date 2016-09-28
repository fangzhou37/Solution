package _22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] buffer = new char[n*2];
        generate(res, buffer, 0, n, n);
        return res;
    }

    private void generate(List<String> res, char[] buffer, int i, int left, int right) {
        if (i == buffer.length) {
            res.add(new String(buffer));
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            buffer[i] = '(';
            generate(res, buffer, i + 1, left - 1, right);
        }
        if (right > 0) {
            buffer[i] = ')';
            generate(res, buffer, i+1, left, right-1);
        }
    }
}
