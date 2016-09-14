package _40CombinationSumII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        int j = i;
        while (j < candidates.length && candidates[i] == candidates[j]) {   // 去重
            j++;
        }
        backTracking(candidates, j, target, buffer, res);

        for (int ind = i; ind < j; ind++) {
            target -= candidates[i];
            buffer.addLast(candidates[i]);
            backTracking(candidates, j, target, buffer, res);
        }
        for (int ind = i; ind < j; ind++) {
            buffer.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
