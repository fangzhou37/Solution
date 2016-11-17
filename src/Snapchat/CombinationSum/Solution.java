package Snapchat.CombinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 非正数怎么办?  很有可能会出现无穷多解法
    // 数字可以重复无限次使用
    public int combinationSum(int[] candidates, int target) {
        int[] solution = new int[target + 1];
        solution[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int candidate : candidates) {
                if (i - candidate >= 0) {
                    solution[i] += solution[i - candidate];
                }
            }
        }
        return solution[target];
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> buffer = new LinkedList<>();
        //dfs(candidates, 0, buffer, target, 0, res);
        dfs(candidates, buffer, target, 0, res);
        return res;
    }

    private void dfs(int[] candidates, LinkedList<Integer> buffer, int target, int curSum, List<List<Integer>> res) {
        if (target == curSum) {
            res.add(new LinkedList<>(buffer));
            return;
        }
        for (int candidate : candidates) {
            if (candidate + curSum > target) {
                continue;
            }
            buffer.addLast(candidate);
            dfs(candidates, buffer, target, curSum + candidate, res);
            buffer.removeLast();
        }
    }

    /*private void dfs(int[] candidates, int i, LinkedList<Integer> buffer, int target, int curSum, List<List<Integer>> res) {
        if (target == curSum) {
            res.add(new LinkedList<>(buffer));
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
    }*/

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        System.out.println(new Solution().combinationSum(arr, 4));
    }
}
