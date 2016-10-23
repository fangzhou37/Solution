package Snapchat.CombinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 数字可以重复无限次使用
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> buffer = new LinkedList<>();
        dfs(candidates, 0, buffer, target, 0, res);
        return res;
    }

    private void dfs(int[] candidates, int i, LinkedList<Integer> buffer, int target, int curSum, List<List<Integer>> res) {
        if (target == curSum) {
            res.add(new LinkedList<Integer>(buffer));
            return;
        }
        if (i >= candidates.length) {
            return;
        }
        if (candidates[i] + curSum > target) {
            return;
        }
        dfs(candidates, i + 1, buffer, target, curSum, res);

        buffer.addLast(candidates[i]);
        dfs(candidates, i, buffer, target, curSum + candidates[i], res);
        buffer.removeLast();
    }

    public static void main(String[] args) {

    }
}
