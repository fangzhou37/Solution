package _22GenerateParentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        int l = n, r = n;
        char[] buf = new char[n*2];
        List<String> res = new LinkedList<>();
        dfs(buf, 0, res, l, r);
        return res;
    }

    private void dfs(char[] buf, int ind, List<String> res, int l, int r) {
        if (l == 0 && r == 0) {
            res.add(new String(buf));
            return;
        }
        if (l > r) {    // invalid: ())..
            return;
        }
        if (l > 0) {
            buf[ind] = '(';
            dfs(buf, ind+1, res, l-1, r);
        }
        if (l < r) {
            buf[ind] = ')';
            dfs(buf, ind+1, res, l, r-1);
        }
    }
}
