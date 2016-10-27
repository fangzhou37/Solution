package Snapchat.CombinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> buffer = new LinkedList<>();
        dfs(candidates, 0, buffer, target, 0, res);
        return res;
    }

    private void dfs(int[] candidates, int i, LinkedList<Integer> buffer, int target, int curSum, List<List<Integer>> res) {
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

        int count = 1;
        int next = i + 1;
        for (; next < candidates.length; next++) {
            if (candidates[next] == candidates[i]) {
                count++;
            } else {
                break;
            }
        }
        dfs(candidates, next, buffer, target, curSum, res);

        for (int j = 0; j < count; j++) {
            buffer.addLast(candidates[i]);
            curSum += candidates[i];
            dfs(candidates, next, buffer, target, curSum, res);
            // buffer.removeLast();  // 注意,这里不能马上remove,否则影响后续
        }
        for (int j = 0; j < count; j++) {
            buffer.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10,1,2,7,6,1,5};
        System.out.println(new Solution2().combinationSum2(arr, 8));
    }
}
