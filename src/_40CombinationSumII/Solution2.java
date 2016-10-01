package _40CombinationSumII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        if (i >= candidates.length) {   // 易错，不要放target == 0 之前
            return;
        }
        if (candidates[i] > target) {
            return;
        }
        int count = 1, j = i+1;
        while (j < candidates.length && candidates[j] == candidates[j-1]) {
            j++;
            count++;
        }

        for (int k = 0; k <= count; k++) {
            dfs(candidates, j, buffer, target, res);
            buffer.addLast(candidates[i]);
            target -= candidates[i];
        }
        for (int k = 0; k <= count; k++) {
            buffer.removeLast();
        }
    }

    public static void main(String[] args) {
        new Solution2().combinationSum2(new int[]{1}, 1);
    }
}
