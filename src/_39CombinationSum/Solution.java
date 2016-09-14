package _39CombinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        LinkedList<Integer> buffer = new LinkedList<>();
        backTracking(candidates, 0, target, buffer, res);
        return res;
    }

    private void backTracking(int[] candidates, int i, int target, LinkedList<Integer> buffer, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<Integer>(buffer));
            return; // assume that all candidates are positive
        }
        if (i >= candidates.length) {
            return;
        }
        if (target < candidates[i]) {
            return;
        }
        backTracking(candidates, i+1, target, buffer, res);

        buffer.addLast(candidates[i]);
        backTracking(candidates, i, target - candidates[i], buffer, res);
        buffer.removeLast();
    }
}
