package _77Combinations;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            List<List<Integer>> res = new LinkedList<>();
            res.add(new LinkedList<Integer>());
            return res;
        }
        if (k == n) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            List<List<Integer>> res = new LinkedList<>();
            res.add(row);
            return res;
        }
        List<List<Integer>> sub = combine(n-1, k-1);
        for (List<Integer> s : sub) {
            s.add(n);
        }
        sub.addAll(combine(n-1, k));
        return sub;
    }
}
