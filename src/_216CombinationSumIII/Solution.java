package _216CombinationSumIII;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        if (n == 0) {
            return res;
        }
        LinkedList<Integer> buffer = new LinkedList<>();
        backTracking(1, k, n, buffer, res);
        return res;
    }

    private void backTracking(int cur, int k, int target, LinkedList<Integer> buffer, List<List<Integer>> res) {
        if (target == 0) {
            if (buffer.size() == k) {
                res.add(new LinkedList<>(buffer));
            }
            return; // assume that all candidates are positive
        }
        if (cur > 9) {
            return;
        }
        if (buffer.size() >= k) {
            return;
        }

        backTracking(cur+1, k, target, buffer, res);

        buffer.addLast(cur);
        backTracking(cur+1, k, target-cur, buffer, res);
        buffer.removeLast();
    }
}
