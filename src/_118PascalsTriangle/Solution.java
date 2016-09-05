package _118PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        res.add(new ArrayList(cur));
        for (int i = 1; i < numRows; i++) {
            cur = res.get(res.size()-1);
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 0; j < cur.size()-1; j++) {
                next.add(cur.get(j) + cur.get(j+1));
            }
            next.add(1);
            res.add(next);
        }
        return res;
    }
}
