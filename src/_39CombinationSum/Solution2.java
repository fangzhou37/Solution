package _39CombinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    // Cannot use two pointers
    // DP turns to be hard since this requires to return path
    // DFS
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        LinkedList<Integer> buffer = new LinkedList<>();
        dfs(candidates, 0, buffer, target, res);
        return res;
    }

    private void dfs(int[] candidates, int i, LinkedList<Integer> buffer, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(buffer));
            return;
        }
        if (i >= candidates.length) {
            return;
        }
        if (candidates[i] > target) {
            return;
        }
        dfs(candidates, i+1, buffer, target, res);
        buffer.addLast(candidates[i]);
        dfs(candidates, i, buffer, target - candidates[i], res);
        buffer.removeLast();
    }
}
